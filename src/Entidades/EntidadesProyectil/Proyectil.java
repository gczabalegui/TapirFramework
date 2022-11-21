package Entidades.EntidadesProyectil;

import Entidades.Entidad;

public abstract class Proyectil extends Entidad{
	
	protected int poder_desinfeccion; 
	
	
	public void setPoderDesinfeccion(int pd) {
		
		poder_desinfeccion = pd;
	}

	public int getPoderDesinfeccion() {	
		
		return poder_desinfeccion;		
	}	
}
