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
import Entidades.EntidadesPremio.Premio;
import Entidades.EntidadesPremio.SuperArmaSanitaria;
import Entidades.EntidadesProyectil.ProyectilJugador;

public class VisitorPocionDeVida implements Visitor{

	protected PocionDeVida efecto; 
	
	public VisitorPocionDeVida(PocionDeVida e) {
		
		efecto = e;
	}
	
	@Override
	public void visit(Jugador j) {
		
		efecto.aplicarPremio();		
		Juego.instancia().removeEntidadEnJuego(efecto);
		Juego.instancia().getGUI().remover(efecto.getEntidadGrafica().getLabel());
	}

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
