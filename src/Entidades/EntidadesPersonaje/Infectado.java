package Entidades.EntidadesPersonaje;

import java.util.Random;

import Entidades.EntidadesPremio.CuarentenaObligatoria;
import Entidades.EntidadesPremio.PocionDeVida;
import Entidades.EntidadesPremio.Premio;
import Entidades.EntidadesPremio.SuperArmaSanitaria;
import Logica.Juego;
import Logica.Visitor;
import Logica.VisitorInfectado;

public class Infectado extends Personaje{
	
	protected int rango_alcance; 
	protected int capacidad_danio; 
	
	public Infectado() {
		
		visitor = new VisitorInfectado(this);
	}
	
	public int getDanio() {
		
		return capacidad_danio;
	}
	
	public void otorgarPremio() {
				
		Random numero = new Random(); 
		int n = numero.nextInt(3); 
		Premio premio = null;
		
		switch(n) {
			
			case 0: 
				premio = new CuarentenaObligatoria();
				premio.setPosX(this.getPosX());
				premio.setPosY(this.getPosY());	
				break;
			case 1: 
				premio = new SuperArmaSanitaria();
				premio.setPosX(this.getPosX());
				premio.setPosY(this.getPosY());
				break;	
			case 2: 
				premio = new PocionDeVida();
				premio.setPosX(this.getPosX());
				premio.setPosY(this.getPosY());	
				break;	
		}
		
		if(premio != null) {
			Juego.instancia().addEntidadEnJuego(premio);
		}	
		
	}
	
	public void accionar() {			
		
		int posicionX = this.getPosX();
		int posicionY = this.getPosY(); 
		
		if(carga_viral > 0) {
			
			if(posicionY < 520) {
				posicionY+= this.getVelocidad();
				this.setPosY(posicionY);
				this.getEntidadGrafica().getLabel().setLocation(posicionX, posicionY);
				this.getEntidadGrafica().getLabel().repaint();
			}
			else {			
				this.setPosY(400);
				this.getEntidadGrafica().getLabel().setLocation(posicionX, posicionY);
				this.getEntidadGrafica().getLabel().repaint();
			}
		}
	}

	public void morir() {
		
		if(carga_viral <= 0) {
			
			juego.instancia().getNivel().agregarAEliminar(this);
			estaVivo = false;
			otorgarPremio();
			this.setVelocidad(0);				
		}	
	}
	
	@Override
	public void aceptar(Visitor a) {
		
		a.visit(this);
	}
	
	public void setearCuarentena() {		
		
		velocidad = 0;
	}
	
	public void volverVelocidad() {
		
		velocidad = 15;
	}
	
	public void duplicarVelocidad() {
		
	}
}
