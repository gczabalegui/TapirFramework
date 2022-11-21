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

public class VisitorProyectilJugador implements Visitor{
	
	protected ProyectilJugador proyectil; 
	
	public VisitorProyectilJugador(ProyectilJugador p) {
		
		proyectil = p;
	}
	@Override
	public void visit(Jugador j) {
		// TODO Auto-generated method stub
		
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
		
		if(a.getEstaVivo()) {
			
			a.setCargaViral(a.getCargaViral()-this.proyectil.getPoderDesinfeccion());
			
			if(a.getCargaViral() <= 0) {
				
				a.morir();

				Juego.instancia().removeEntidadEnJuego(a);
				a.getEntidadGrafica().getLabel().setVisible(false);
				Juego.instancia().getGUI().remover(a.getEntidadGrafica().getLabel());;
			}
			else if(a.getCargaViral() < 20 && a.getCargaViral() >0)
				a.duplicarVelocidad(); // método redefinido solo en la clase InfectadoAlpha			
		}	
		
		proyectil.getEntidadGrafica().getLabel().setVisible(false);
		Juego.instancia().removeEntidadEnJuego(proyectil);
		Juego.instancia().getGUI().remover(proyectil.getEntidadGrafica().getLabel());
	}

}
