package Logica;

import Entidades.EntidadesPersonaje.Infectado;
import Entidades.EntidadesPersonaje.Jugador;
import Entidades.EntidadesPremio.CuarentenaObligatoria;
import Entidades.EntidadesPremio.PocionDeVida;
import Entidades.EntidadesPremio.SuperArmaSanitaria;
import Entidades.EntidadesProyectil.ProyectilJugador;

public class VisitorCuarentenaObligatoria implements Visitor{
	
	protected CuarentenaObligatoria efecto;
	
	public VisitorCuarentenaObligatoria(CuarentenaObligatoria e) {
		
		efecto = e;	
	}

	@Override
	public void visit(Jugador j) {
		
		efecto.aplicarPremio();	
		Juego.instancia().removeEntidadEnJuego(efecto);
		Juego.instancia().getGUI().remover(efecto.getEntidadGrafica().getLabel());
	}

	@Override
	public void visit(Infectado a) {
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

	public void visit(SuperArmaSanitaria s) {
		
		
	}
	@Override
	public void visit(ProyectilJugador pj) {
		// TODO Auto-generated method stub
		
	}



}