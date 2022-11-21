package Entidades.EntidadesPremio;

import java.util.LinkedList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

import Entidades.Entidad;
import Entidades.EntidadGrafica;
import Entidades.EntidadesPersonaje.Infectado;
import Logica.Juego;
import Logica.Visitor;
import Logica.VisitorCuarentenaObligatoria;

public class CuarentenaObligatoria extends EfectoTemporal {
	
	
	public CuarentenaObligatoria() {
		
		velocidad = 5;
		entidadGrafica = new EntidadGrafica();
		cargarEntidadGrafica();	
		visitor = new VisitorCuarentenaObligatoria(this);
	}
	
	public void aplicarPremio() {
		
		LinkedList<Entidad> entidades = (LinkedList<Entidad>) Juego.instancia().getEntidadesEnJuego();

		
		for(Entidad entidad : entidades) {
			
			if(entidad != null)
				entidad.setearCuarentena();	
		}
		
		Juego.instancia().setHayCuarentena(true);
		
		Timer timer = new Timer(); 
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				
				Juego.instancia().setHayCuarentena(false);
				

				for(Entidad entidad1 : entidades) {
					
					if(entidad1 != null)
						entidad1.volverVelocidad();
				}
		}
		};
		
		timer.schedule(task, 10000);
	}
	
	private void cargarEntidadGrafica() {
		
		Random NumeroAleatorio= new Random();
		int numero = NumeroAleatorio.nextInt(300) + 370;
        entidadGrafica.getLabel().setBounds(numero, 300, 100, 100);
		entidadGrafica.getLabel().setIcon(new ImageIcon(this.getClass().getResource("/Imagenes/PremioCuarentena.png")));
		Juego.instancia().getGUI().insertarEntidad(entidadGrafica.getLabel());
	}

	@Override
	public void aceptar(Visitor a) {
		
		a.visit(this);
	}

}
