package Logica;

import Entidades.EntidadesPersonaje.Infectado;
import Entidades.EntidadesPersonaje.InfectadoAlpha;


import Entidades.EntidadesPersonaje.InfectadoBeta;
import Entidades.EntidadesPersonaje.Jugador;
import Entidades.EntidadesPremio.CuarentenaObligatoria;
import Entidades.EntidadesPremio.PocionDeVida;
import Entidades.EntidadesPremio.SuperArmaSanitaria;
import Entidades.EntidadesProyectil.ProyectilJugador;

public interface Visitor {
	
	public void visit (Jugador j);
	public void visit (Infectado a);
	public void visit (CuarentenaObligatoria c);
	public void visit(PocionDeVida p);
	public void visit(SuperArmaSanitaria s);
	public void visit (ProyectilJugador pj);
}
