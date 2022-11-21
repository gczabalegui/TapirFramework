package Logica;


import java.util.LinkedList;
import java.util.Random;

import Entidades.EntidadesPersonaje.Infectado;
import Entidades.EntidadesPersonaje.InfectadoAlpha;
import Entidades.EntidadesPersonaje.InfectadoBeta;

public class Nivel {
    protected int nivel;
    protected int infectados_tanda;
    protected int tanda_actual;
    protected int infectados_nivel;
    protected LinkedList<Infectado> infectados; 
    protected LinkedList<Infectado> aEliminar; 
    
    public Nivel() {
    	
        nivel = 1;
        infectados_nivel = 6;
        infectados_tanda = infectados_nivel;
        tanda_actual = 1;
        infectados = new LinkedList<Infectado>();
        aEliminar = new LinkedList<Infectado>();
        agregarInfectados(infectados);
    }

    public LinkedList<Infectado> getInfectados() {
        return infectados;
    }

    public int getInfectadosTanda() {
        return infectados_tanda;
    }

    public int getTandaActual() {
        return tanda_actual;
    }

    public int getNivel() {
        return nivel;
    }
    
    public void setTanda(int i){
    	
    	tanda_actual= 1; 	
    }
    
    public void eliminarInfectado() {
    	
    	this.infectados_tanda = infectados_tanda-1;    	
    }
    
    public boolean tieneInfectados() {
    	
    	return (infectados.size() != aEliminar.size()); 
    }
    
    public void agregarAEliminar(Infectado i) {
    	
    	aEliminar.add(i);
    }
    
    public void subirTanda() { 
    	
       tanda_actual = 2;
       infectados.clear();
       aEliminar.clear();
       infectados_tanda = infectados_nivel;
       agregarInfectados(infectados);     		
    }

    public void aumentarNivel() {
    	
      	nivel++;
	    tanda_actual = 1;
    	infectados.clear();
    	aEliminar.clear();
    	infectados = new LinkedList<Infectado>();
    	aEliminar = new LinkedList<Infectado>(); 
    	infectados_nivel = 10;
	    agregarInfectados(infectados);    	 
    }
    
    public void agregarInfectados(LinkedList<Infectado> inf) {
    	
    	Random random = new Random();
        int numAleatorio;
        int i = 0;
        while(i<infectados_nivel){
        	
            numAleatorio = random.nextInt(2);
            if(numAleatorio == 0)
                inf.add(new InfectadoAlpha());  
            else
                inf.add(new InfectadoBeta());
            i++;
        }
    }
}
