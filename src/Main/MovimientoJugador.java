package Main;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;

import Entidades.EntidadesPersonaje.Jugador;
import Entidades.EntidadesProyectil.Proyectil;
import Entidades.EntidadesProyectil.ProyectilJugador;
import Logica.Juego;

public class MovimientoJugador implements KeyListener{
	
	private Jugador jugador;
	private JLabel lblJugador;
	private MapaGUI gui;
	
	public MovimientoJugador(MapaGUI gui) {
		
		 jugador = Jugador.instancia();
		 lblJugador = jugador.getEntidadGrafica().getLabel();
		 this.gui = gui;
	}
	
	public void keyPressed(KeyEvent ke, JLabel lblFondo) { 		
		
		if (ke.getKeyChar() == 'a' || ke.getKeyChar() == 'A' || ke.getKeyCode() == 37) {	
		
			if (lblJugador.getX()-10>=lblFondo.getX()) {        			
				lblJugador.setLocation(lblJugador.getX()-10,lblJugador.getY());
				jugador.setPosX(lblJugador.getX()-10);
				jugador.setPosY(lblJugador.getY());
			}
		} 
		else if (ke.getKeyChar() == 'd' || ke.getKeyChar() == 'D' || ke.getKeyCode() == 39) {        		
	
			
			if (lblJugador.getX()+10<=(lblFondo.getWidth()-lblJugador.getWidth())) {
				lblJugador.setLocation(lblJugador.getX()+10,lblJugador.getY());
				jugador.setPosX(lblJugador.getX()+10);
				jugador.setPosY(lblJugador.getY());
				
			}
		}
		else if (ke.getKeyCode() == 32 || ke.getKeyChar() == 'w') {
			
			Proyectil proyectil = new ProyectilJugador();
			jugador.getArmaSanitaria().disparar(proyectil);
			Juego.instancia().addEntidadEnJuego(proyectil);
			gui.insertarEntidad(proyectil.getEntidadGrafica().getLabel());
		}
		
	}
	

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
