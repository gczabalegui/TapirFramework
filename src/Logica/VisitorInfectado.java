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
import Main.MapaGUI;

public class VisitorInfectado implements Visitor{
	
	protected Infectado infectado; 
	
	public VisitorInfectado(Infectado i) {
		
		infectado = i;;
	}
	
	@Override
	public void visit(Jugador j) { 
		
        int cargaViralJugador = j.getCargaViral(); 
        if((infectado.getCargaViral() > 0) && (cargaViralJugador<=100)){
        	
            cargaViralJugador = cargaViralJugador+infectado.getDanio();
            
            if (cargaViralJugador>=100) {
            	
                cargaViralJugador=100; 
             } 
            j.setCargaViral(cargaViralJugador);
            System.out.println(j.getCargaViral()); 
         } 
    }

	@Override
	public void visit(Infectado a) {}

	@Override
	public void visit(ProyectilJugador pj) {}

	@Override
	public void visit(CuarentenaObligatoria c) {}

	@Override
	public void visit(PocionDeVida p) {}

	@Override
	public void visit(SuperArmaSanitaria s) {}

}
