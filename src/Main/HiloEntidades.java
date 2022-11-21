package Main;

import java.util.LinkedList;
import java.util.List;

import javax.swing.SwingUtilities;

import Entidades.Entidad;
import Logica.Juego;
import Logica.Nivel;

public class HiloEntidades extends Thread{
	

	protected Juego juego;
	protected MapaGUI GUI;
		
	public HiloEntidades(MapaGUI GUI) {			
	
		this.start();
	}
		
	@Override
	public void run() {
		do {				
            try {
                Thread.sleep(500);
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            Juego.instancia().accionar();
            
		}while(true);

	}

}
