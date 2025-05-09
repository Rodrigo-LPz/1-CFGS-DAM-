/*SEARCH BY USING A CITY NAME (e.g. athens) OR A COMMA-SEPARATED CITY NAME ALONG WITH THE COUNTRY CODE (e.g. athens,gr)*/
const form = document.querySelector(".banner form");
const input = document.querySelector(".banner input");
const msg = document.querySelector(".banner .msg");
const list = document.querySelector(".wheather-window .cities");
// Clava ApiKey.
const apiKey = "5fc220b83232dbad7aa1914aebcedbce";

form.addEventListener("submit", e =>{
  e.preventDefault();
  let inputVal = input.value;
  // Comprobante de que la ciudad ya ha sido buscada. En caso de que sí, se muestra un mensaje.
  const listItems = list.querySelectorAll(".wheather-window .city");
  const listItemsArray = Array.from(listItems);

  if (listItemsArray.length > 0){
    const filteredArray = listItemsArray.filter(el =>{
      let content = "";
      //athens,gr
      if (inputVal.includes(",")){
        //athens,grrrrrr->invalid country code, so we keep only the first part of inputVal
        if (inputVal.split(",")[1].length > 2){
          inputVal = inputVal.split(",")[0];
          content = el
            .querySelector(".city-name span")
            .textContent.toLowerCase();
        } else{
          content = el.querySelector(".city-name").dataset.name.toLowerCase();
        }
      } else{
        //athens
        content = el.querySelector(".city-name span").textContent.toLowerCase();
      }
      return content == inputVal.toLowerCase();
    });

    if (filteredArray.length > 0){
      msg.textContent = `City already searched for/found ${
        filteredArray[0].querySelector(".city-name span").textContent
      } Otherwise, please be more specific by also providing the country's postal code.`;
      form.reset();
      input.focus();
      return;
    }
  }

  //ajax (HTML)
  const url = `https://api.openweathermap.org/data/2.5/weather?q=${inputVal}&appid=${apiKey}&units=metric`;

  fetch(url)
    .then(response => response.json())
    .then(data =>{
      const{ main, name, sys, weather } = data;
      const icon = `https://s3-us-west-2.amazonaws.com/s.cdpn.io/162656/${
        weather[0]["icon"]
      }.svg`;

      const li = document.createElement("li");
      li.classList.add("city");
      const markup = `
        <h2 class="city-name" data-name="${name},${sys.country}">
          <span>${name}</span>
          <sup>${sys.country}</sup>
        </h2>
        <div class="city-temp">${Math.round(main.temp)}<sup>°C</sup></div>
        <figure>
          <img class="city-icon" src="${icon}" alt="${
        weather[0]["description"]
      }">
          <figcaption>${weather[0]["description"]}</figcaption>
        </figure>
      `;
      li.innerHTML = markup;
      list.appendChild(li);
    })
    .catch(() =>{
      msg.textContent = "City or parameter is invalid or not included in our system";
    });

  msg.textContent = "";
  form.reset();
  input.focus();
});