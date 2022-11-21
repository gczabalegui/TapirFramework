package Entidades.EntidadesPremio;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

import Entidades.EntidadGrafica;
import Entidades.EntidadesPersonaje.Jugador;
import Logica.Juego;
import Logica.Visitor;
import Logica.VisitorSuperArmaSanitaria;


public class SuperArmaSanitaria extends EfectoTemporal {

	public SuperArmaSanitaria() {

		velocidad = 5;
		entidadGrafica = new EntidadGrafica();
		cargarEntidadGrafica();
		visitor = new VisitorSuperArmaSanitaria(this);
	}
	
	@Override
	public void aplicarPremio() {

		Timer timer = new Timer();
		TimerTask task = new TimerTask() {

			@Override
			public void run() {

				Jugador.instancia().setSuperArmaSanitaria();
				
			}			
		};
		
		timer.schedule(task, 0, 10000);
	}

	private void cargarEntidadGrafica() {	

		Random NumeroAleatorio= new Random();
		int numero = NumeroAleatorio.nextInt(300) + 370;
        entidadGrafica.getLabel().setBounds(numero, 300, 100, 100);
		entidadGrafica.getLabel().setIcon(new ImageIcon(this.getClass().getResource("/Imagenes/PremioSuperArma.png")));
		Juego.instancia().getGUI().insertarEntidad(entidadGrafica.getLabel());
	}

	@Override
	public void aceptar(Visitor a) {
		
		a.visit(this);
	}

}
