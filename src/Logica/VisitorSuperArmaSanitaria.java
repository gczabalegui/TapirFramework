package Logica;

import java.awt.geom.Area;

import Entidades.EntidadesPersonaje.Infectado;
import Entidades.EntidadesPersonaje.InfectadoAlpha;

import Entidades.EntidadesPersonaje.InfectadoBeta;
import Entidades.EntidadesPersonaje.Jugador;
import Entidades.EntidadesPremio.CuarentenaObligatoria;
import Entidades.EntidadesPremio.EfectoTemporal;
import Entidades.EntidadesPremio.ObjetosPreciosos;
import Entidades.EntidadesPremio.PocionDeVida;
import Entidades.EntidadesPremio.SuperArmaSanitaria;
import Entidades.EntidadesProyectil.ProyectilJugador;

public class VisitorSuperArmaSanitaria implements Visitor{

	protected SuperArmaSanitaria efecto;
	
	public VisitorSuperArmaSanitaria(SuperArmaSanitaria e) {
		
		efecto = e;
	}
	@Override
	public void visit(Jugador j) {
		
			efecto.aplicarPremio();	
			Juego.instancia().removeEntidadEnJuego(efecto);
			Juego.instancia().getGUI().remover(efecto.getEntidadGrafica().getLabel());
	}


	@Override
	public void visit(ProyectilJugador pj) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void visit(CuarentenaObligatoria c) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void visit(PocionDeVida p) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void visit(SuperArmaSanitaria s) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void visit(Infectado a) {
		// TODO Auto-generated method stub
		
	}
}
