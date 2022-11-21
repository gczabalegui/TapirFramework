package Entidades.EntidadesPersonaje;

import java.awt.Image;

import javax.swing.ImageIcon;

import Entidades.EntidadGrafica;
import Entidades.EntidadesArma.ArmaSanitaria;
import Logica.Visitor;
import Logica.VisitorJugador;

public class Jugador extends Personaje{	
	
	protected boolean infectado;

	protected ArmaSanitaria arma;
	
	protected static Jugador jugador;
	
	private Jugador() {
		
		velocidad = 10; 
		carga_viral = 0;
		infectado = false;		
		arma = new ArmaSanitaria();
		arma.getProyectil().setPoderDesinfeccion(15);
		entidadGrafica = new EntidadGrafica(); 
		cargarEntidadGrafica();
		visitor = new VisitorJugador(this);
		estaVivo = true;
	}
	
	public static Jugador instancia() {
		
		if(jugador == null)
			jugador = new Jugador();
		
		return jugador;
		
	}
	
	private void cargarEntidadGrafica() {
		
		entidadGrafica.getLabel().setBounds(40, 590, 90, 90);
		entidadGrafica.getLabel().setIcon(new ImageIcon(new ImageIcon(this.getClass().getClassLoader().getResource("Imagenes/Jugador.png")).getImage().getScaledInstance(entidadGrafica.getLabel().getWidth(), entidadGrafica.getLabel().getHeight(), Image.SCALE_DEFAULT)));
		this.setPosX(entidadGrafica.getLabel().getX());
		this.setPosY(entidadGrafica.getLabel().getY());
	}
	
	public void aumentarCargaViralAlpha() {
		
		carga_viral = carga_viral+15;
	}
	
	public void aumentarCargaViralBeta() {
		
		carga_viral = carga_viral+5;
	}
	
	public void setArmaSanitaria() {
		
		arma.getProyectil().setPoderDesinfeccion(15);
	}
	
	public void setSuperArmaSanitaria() {
		
		arma.getProyectil().setPoderDesinfeccion(arma.getPoderDesinfeccion*5);
	}
	
	public ArmaSanitaria getArmaSanitaria() {
		
		return arma;
	}

	public void setInfectado(boolean infectado) {
		
		this.infectado = infectado;
	}
	
	public boolean getInfectado() {
		
		return infectado;
	}
	
	public void morir() {
		
		if(carga_viral >= 100) {
			
			estaVivo = false;
		}		
	}
	@Override
	public void aceptar(Visitor a) {		
		
		a.visit(this);
	}

	@Override
	public void accionar() {
		// TODO Auto-generated method stub
		
	}

}
