package Entidades.EntidadesPersonaje;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Entidades.EntidadGrafica;
import Logica.Juego;
import Logica.Visitor;
import Logica.VisitorInfectado;

public class InfectadoBeta extends Infectado{
	
	public InfectadoBeta() {
		
		carga_viral = 100;
		velocidad = 4; 
		rango_alcance = 25; 
		capacidad_danio = 5; 
		entidadGrafica = new EntidadGrafica();
		cargarEntidadGrafica();
		estaVivo = true;
	}
	
	private void cargarEntidadGrafica() {
		
		Random NumeroAleatorio= new Random();
		int numero;
		numero = NumeroAleatorio.nextInt(300) + 370;
        entidadGrafica.getLabel().setBounds(numero, 400, 170, 150);		
		entidadGrafica.getLabel().setIcon(new ImageIcon(this.getClass().getResource("/Imagenes/Beta.gif")));
        this.setPosX(numero);
        this.setPosY(400);
	} 
	
	public void setearCuarentena() {		
		
		velocidad = 0;
	}
	
	public void volverVelocidad() {
		
		velocidad = 15;
	}
}
