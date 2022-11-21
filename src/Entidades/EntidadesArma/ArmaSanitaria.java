package Entidades.EntidadesArma;

import Entidades.EntidadesPersonaje.Jugador;
import Entidades.EntidadesProyectil.Proyectil;
import Entidades.EntidadesProyectil.ProyectilJugador;
import Logica.Juego;
import Logica.Visitor;

public class ArmaSanitaria extends Arma{
	
	public int getPoderDesinfeccion;

	public ArmaSanitaria() {
		
		cantidad_municion = 20;
		proyectil = new ProyectilJugador();		
	}
	
	public void disparar(Proyectil proyectil) {
		
		if(cantidad_municion >= 0)
			cantidad_municion = 20;
		
		cantidad_municion--;
		proyectil.setPosX(Jugador.instancia().getPosX());
		proyectil.setPosY(Jugador.instancia().getPosY()+5); // asi se ve de una cuando sale :) 
	}

	@Override
	public void aceptar(Visitor a) {
	}

	@Override
	public void accionar() {
		// TODO Auto-generated method stub
		
	}


}
