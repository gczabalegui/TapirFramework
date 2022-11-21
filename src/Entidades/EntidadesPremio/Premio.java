package Entidades.EntidadesPremio;

import Entidades.Entidad;

public abstract class Premio extends Entidad{
	
	public abstract void aplicarPremio();
	
	public void accionar() {
		
		int posicionX = this.getPosX();
		int posicionY = this.getPosY()+this.getVelocidad(); 
		this.getEntidadGrafica().getLabel().setVisible(true);
		this.getEntidadGrafica().getLabel().setLocation(posicionX, posicionY);
		this.setPosY(this.getPosY()+this.getVelocidad());		
	}

}
