package Logica;


import java.awt.Rectangle;
import java.awt.geom.Area;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.Timer;

import Entidades.Entidad;
import Entidades.EntidadesPersonaje.Infectado;
import Entidades.EntidadesPersonaje.Jugador;
import Main.MapaGUI;


public class Juego {
	
	protected Nivel nivel;
	protected List<Entidad> entidades;
	protected static Juego juego;
	protected MapaGUI gui; 
	protected boolean hayCuarentena;
	
	private Juego() { 
		
		entidades = new LinkedList<Entidad>(); 
		hayCuarentena = false;	
		addEntidadEnJuego(Jugador.instancia());
	}
	
    public static Juego instancia() {
    	
        if(juego == null)       	
            juego = new Juego();
 
        
        return juego;
    }
    
	public void removeEntidadEnJuego(Entidad e) {
		
		entidades.remove(e);
	}
	
	public void setNivel(Nivel n) {
		
		nivel = n;
	}

	public void addEntidadEnJuego(Entidad e) {
		
		entidades.add(e);
    }
	
	public List<Entidad> getEntidadesEnJuego() {
		
		return entidades;
	}
	
	public Nivel getNivel() {
		
		return nivel;
	}
	
	public void setHayCuarentena(boolean hay) {
		
		hayCuarentena = hay;
	}
	
	public boolean getHayCuarente() {
		
		return hayCuarentena;
	}
	
	public void setGUI(MapaGUI gui) {
		
		this.gui = gui;
	}
	
	public MapaGUI getGUI() {		
		
		return gui;
	}
	
 	public void accionar() {
 		
 
 		for(int i = 0; i < entidades.size();i++) {

			Entidad e1 = entidades.get(i);
			
			for(int j = 0; j < entidades.size();j++) {
				
				Entidad e2 = entidades.get(j);
				
				if(!e1.equals(e2) && verificarColision(e1,e2)) {
					
					e1.aceptar(e2.getVisitor());
					gui.modificarCargaViral();
				}				
			}			
			e1.accionar();
 		}	
 		
 		chequearCambiodeNivel();
 	}
 		
 	private boolean verificarColision(Entidad entidad_1, Entidad entidad_2) {

        Rectangle r1 = entidad_1.getEntidadGrafica().getLabel().getBounds();
        r1.height/=2;
        r1.width/=2;
        Rectangle r2= entidad_2.getEntidadGrafica().getLabel().getBounds();
        r2.height/=2;
        r2.width/=2;
        return r1.intersects(r2);
     }
 	
 	private void chequearCambiodeNivel() { 		
 		
 		if(!nivel.tieneInfectados()) { 	 	
 			
 			if(nivel.getNivel() == 1) {
 				
 				if(nivel.getTandaActual() == 1) {
 					
	 				nivel.subirTanda(); 				
	 				gui.modificarTanda(1);	 				 
 	 				gui.reanudarTodo();
 				}
 				else {// estoy en la tanda 2
 					
 	 				nivel.aumentarNivel(); 	 				
 	 				gui.modificarTanda(0);
 	 				gui.cambiarNivel(1); 
 	 				gui.reanudarTodo();
 				}
 			}
 			else {//estoy en el nivel 2			
 			
 				if(nivel.getTandaActual() == 1) { 			
 				
	 				nivel.subirTanda(); 				
	 				gui.modificarTanda(1);
	 				gui.reanudarTodo();
				}
 				else
 					gui.ganar(); 			
 			} 
 		}	
 		else if(Jugador.instancia().getCargaViral() >= 100)
 			gui.perder();
 	}

}
