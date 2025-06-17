package com.company.juego;

import static org.junit.Assert.*;
import org.junit.Test;

class TestJuego{
	public class PPTWhiteBoxTest{
	    @Test
	    public void testEmpate() {
	        assertEquals("Empate", JuegoPPT_Sesion1.obtenerResultado("Piedra", "Piedra"));
	        assertEquals("Empate", JuegoPPT_Sesion1.obtenerResultado("Agua", "Agua"));
	    }

	    @Test
	    public void testGanaste() {
	        assertEquals("Ganaste", JuegoPPT_Sesion1.obtenerResultado("Piedra", "Tijera"));
	        assertEquals("Ganaste", JuegoPPT_Sesion1.obtenerResultado("Papel", "Piedra"));
	        assertEquals("Ganaste", JuegoPPT_Sesion1.obtenerResultado("Tijera", "Papel"));
	        assertEquals("Ganaste", JuegoPPT_Sesion1.obtenerResultado("Agua", "Humanoide"));
	        assertEquals("Ganaste", JuegoPPT_Sesion1.obtenerResultado("Humanoide", "Piedra"));
	    }

	    @Test
	    public void testPerdiste() {
	        assertEquals("Perdiste", JuegoPPT_Sesion1.obtenerResultado("Piedra", "Papel"));
	        assertEquals("Perdiste", JuegoPPT_Sesion1.obtenerResultado("Papel", "Tijera"));
	        assertEquals("Perdiste", JuegoPPT_Sesion1.obtenerResultado("Tijera", "Piedra"));
	        assertEquals("Perdiste", JuegoPPT_Sesion1.obtenerResultado("Agua", "Piedra"));
	        assertEquals("Perdiste", JuegoPPT_Sesion1.obtenerResultado("Humanoide", "Tijera"));
	    }
	}
}