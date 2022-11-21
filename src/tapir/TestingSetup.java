package tapir;

import java.util.HashMap;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Entidades.EntidadesPersonaje.Infectado;
import Entidades.EntidadesPersonaje.Jugador;

public class TestingSetup {
	public static void setup() {
		HashMap<Integer, String> mapObjectsToCallSequence = null; 
		HashMap<String, String> mapMethodsToSymbols = null; 
		Pattern regularExpression = null; 
		Matcher matcher = null;
		
		//Specification of the test class\
		TestingCore.mapClassToTestingInformation = new HashMap<>();
			
		
		// Testing setup for Infectado Class
		//Definition of the methods and their corresponding symbols
		mapObjectsToCallSequence = new HashMap<>(); 
		mapMethodsToSymbols = new HashMap<String, String>();
		mapMethodsToSymbols.put("Entidades.EntidadesPersonaje.Infectado.<init>", "c");
		mapMethodsToSymbols.put("Entidades.EntidadesPersonaje.Infectado.accionar", "a");
		mapMethodsToSymbols.put("Entidades.EntidadesPersonaje.Infectado.otorgarPremio", "p");
		mapMethodsToSymbols.put("Entidades.EntidadesPersonaje.Infectado.morir", "m");
		//Definition of the regular expression
		regularExpression = Pattern.compile("c(a|p)*m");
		//Initializing the regular expressions controller
		matcher = regularExpression.matcher("");	
		// All information related to how the Account class is testing is store in a TestingInformation instance
		TestingInformation ti = new TestingInformation(Infectado.class.toString(), mapObjectsToCallSequence, mapMethodsToSymbols, regularExpression, matcher, true);
		TestingCore.mapClassToTestingInformation.put(Infectado.class.toString(), ti);
		
		mapObjectsToCallSequence = null; 
		mapMethodsToSymbols = null; 
		regularExpression = null; 
		matcher = null;
		
		// Testing setup for Jugador Class
		//Definition of the methods and their corresponding symbols
		mapObjectsToCallSequence = new HashMap<>(); 
		mapMethodsToSymbols = new HashMap<String, String>();
		mapMethodsToSymbols.put("Entidades.EntidadesPersonaje.Jugador.instancia()", "c");
		mapMethodsToSymbols.put("Entidades.EntidadesPersonaje.Jugador.setArmaSanitaria", "a");
		mapMethodsToSymbols.put("Entidades.EntidadesPersonaje.Jugador.setSuperArmaSanitaria", "s");
		mapMethodsToSymbols.put("Entidades.EntidadesPersonaje.Jugador.aumentarCargarViralAlpha", "v");
		mapMethodsToSymbols.put("Entidades.EntidadesPersonaje.Jugador.aumentarCargarViralBeta", "d");
		mapMethodsToSymbols.put("Entidades.EntidadesPersonaje.Jugador.setInfectado", "i");
		mapMethodsToSymbols.put("Entidades.EntidadesPersonaje.Jugador.morir", "m");
		//Definition of the regular expression
		regularExpression = Pattern.compile("c(a|s|w|d|i)*m");
		//Initializing the regular expressions controller
		matcher = regularExpression.matcher("");	
		// All information related to how the Check Account class is testing is store in a TestingInformation instance
		ti = new TestingInformation(Jugador.class.toString(), mapObjectsToCallSequence, mapMethodsToSymbols, regularExpression, matcher, false);
		TestingCore.mapClassToTestingInformation.put(Jugador.class.toString(), ti);
}
	
}
