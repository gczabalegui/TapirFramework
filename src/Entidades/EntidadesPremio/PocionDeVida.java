package Entidades.EntidadesPremio;

import java.util.Random;

import javax.swing.ImageIcon;

import Entidades.EntidadGrafica;
import Entidades.EntidadesPersonaje.Jugador;
import Logica.Juego;
import Logica.Nivel;
import Logica.Visitor;
import Logica.VisitorPocionDeVida;

public class PocionDeVida extends ObjetosPreciosos{
	
	public PocionDeVida() {
		
		velocidad = 5;
		entidadGrafica = new EntidadGrafica();
		cargarEntidadGrafica();
		visitor = new VisitorPocionDeVida(this);
	}
	
	public void aplicarPremio() {
		
		Jugador.instancia().setCargaViral(0);
	}
	
	protected void cargarEntidadGrafica() {
		
		Random NumeroAleatorio= new Random();
		int numero = NumeroAleatorio.nextInt(300) + 370;
        entidadGrafica.getLabel().setBounds(numero, 300, 100, 100);
		entidadGrafica.getLabel().setIcon(new ImageIcon(this.getClass().getResource("/Imagenes/PremioPocion.png")));
		Juego.instancia().getGUI().insertarEntidad(entidadGrafica.getLabel());
	}
	
	public void aceptar(Visitor a) {
		
		a.visit(this);
	}

}
