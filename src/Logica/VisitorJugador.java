package Logica;

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

public class VisitorJugador implements Visitor {

	protected Jugador jugador; 
	
	public VisitorJugador(Jugador j) {
		
		jugador = j;
	}
	
	@Override
	public void visit(Jugador j) {}
	
	
	@Override	
	public void visit(ProyectilJugador pj) {}

	@Override
	public void visit(CuarentenaObligatoria c) {}

	@Override
	public void visit(PocionDeVida p) {}

	@Override
	public void visit(SuperArmaSanitaria s) {}

	@Override
	public void visit(Infectado a) {}




}
