package Entidades.EntidadesArma;

import Entidades.Entidad;
import Entidades.EntidadesProyectil.Proyectil;

public abstract class Arma extends Entidad{
	
	protected int cantidad_municion; 
	protected Proyectil proyectil;
	
	public abstract void disparar(Proyectil p);
	
	
	public void setMunicion(int municion) {
		
		cantidad_municion = municion;
	}
	
	public void setProyectil(Proyectil p) {
		
		proyectil = p;
	}
	
	public Proyectil getProyectil() {
		
		return proyectil;
	}
	
	public int getMunicion() {
		
		return cantidad_municion;
	}
}
