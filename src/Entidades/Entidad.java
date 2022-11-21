package Entidades;

import Logica.Juego;
import Logica.Nivel;
import Logica.Visitor;


public abstract class Entidad  {	
	
	protected Nivel nivel;
	
	protected boolean estaVivo = true;
			
	protected int posX, posY;
	
	protected int velocidad;	
	protected int ancho;
	
	protected int alto;
	
	protected EntidadGrafica entidadGrafica;
	
	protected Juego juego;
	
	protected Visitor visitor; 

	public abstract void aceptar(Visitor a);

	public void setVelocidad(int v) {
		
		velocidad = v;
	}

	public void setPosX(int x) {
		
		posX = x;
	}
	
	public void setPosY(int y) {
		
		posY = y;
	}
	
	public int getPosX() {
		
		return posX;
	}

	public int getPosY() {
		
		return posY;
	}
	
	public int getVelocidad() {
		
		return velocidad;
	}
	
	public Nivel getNivel() {
		
		return nivel;
	}
	
	public void setEntidadGrafica(EntidadGrafica e) {
		
		entidadGrafica = e;
	}
	
	public EntidadGrafica getEntidadGrafica() {
		
		return entidadGrafica;
	}
	
	public void setVisitor(Visitor v) {
		
		visitor = v;
	}
	
	public Visitor getVisitor() {
		
		return visitor; 
	}
	public abstract void accionar();
	
	public void setearCuarentena() {
		
	}
	
	public void volverVelocidad() {
		
		
	}
}
