function PonerMensaje(Mensaje){
    console.log(Mensaje);
}

setTimeout(function(){
    PonerMensaje("Su ejecución se hará tras 5000 milisegundos o el equivalente a 5 segundos: ");
}, 5000);
