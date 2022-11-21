package Main;

import Logica.Juego;

import java.awt.Point;
import java.util.LinkedList;

import javax.swing.JLabel;

import Entidades.EntidadesPersonaje.Infectado;

public class MovimientoInfectados extends Thread{
	
	protected LinkedList<Infectado> infectados;
	protected MapaGUI gui;
	
	public MovimientoInfectados(MapaGUI gui) {
		
		infectados = (LinkedList<Infectado>) Juego.instancia().getNivel().getInfectados();	
		this.gui = gui;
		this.start();
	}
	
	@Override
	public void run() {
		
		try {
			for(Infectado i : infectados)		
				
				if(i == null){ 
				
					Thread.sleep(20000);			
				}
				else {
					
					JLabel infectado = i.getEntidadGrafica().getLabel();
					gui.insertarEntidad(infectado);
					Juego.instancia().addEntidadEnJuego(i);
					Point p = infectado.getBounds().getLocation();
					i.setPosX((int) p.getX());
					i.setPosY((int) p.getY());
					int numero = (int) (Math.random() * 6000) + 1;
					Thread.sleep(numero);

				}
		}
		catch(InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}

}
