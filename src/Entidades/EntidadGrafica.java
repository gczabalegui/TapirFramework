package Entidades;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class EntidadGrafica{
	
	protected JLabel grafica; // Estado actual de la imagen
    protected ImageIcon imagenes[]; // Conjunto de imagenes;
    protected Entidad entidad;
    
    public EntidadGrafica() {
    	
        grafica = new JLabel();
        imagenes = new ImageIcon[10];
    }
    
    public JLabel getLabel() {
    	
    	return grafica;    	
    }
    
    public void setGrafica(JLabel grafica) {
    	
    	this.grafica = grafica;
    }
}
