package Main;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import Entidades.EntidadesPersonaje.Jugador;
import Logica.Juego;
import Logica.Nivel;

import java.awt.Color;
import java.awt.Dimension;

public class MapaGUI extends JFrame {

	private JPanel contentPane;
	private JLayeredPane panel;
	private JLabel lblFondo; 
	private JLabel lblPanel;
	private JLabel lblJugador;
	private JLabel lblNivelActual;
	private JLabel lblTandaActual;
	private JLabel lblCargaViral;
	private ImageIcon lblFondoActual;
	private HiloEntidades tiempo;
	private MovimientoJugador movimiento = new MovimientoJugador(this);
	private MovimientoInfectados infectados;
	private Juego juego;
	protected Nivel nivel;
	protected Thread hiloJuego;
	protected JLabel lblBarricada;
	protected JButton btnJugar;
	protected JButton btnFinalizar;		
	private String [] fondos=new String[] {"Imagenes/FondoNivel1.jpg", "Imagenes/FondoNivel2.jpg"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MapaGUI frame = new MapaGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the frame.
	 */
	
	
	public MapaGUI() {
		
		inicializarGUI();
		inicializarPanelNivel(); 
		addKeyListener(new Adapter());	
		juego = Juego.instancia();
		juego.setGUI(this);
		
		juego.setNivel(new Nivel());
		infectados = new MovimientoInfectados(this);		
		tiempo = new HiloEntidades(this);
		
	}
	
		
	public void inicializarGUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1130, 710);
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setSize(this.getSize());
		contentPane.setOpaque(false);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		panel = new JLayeredPane();
		panel.setLocation(0, 0);
		panel.setSize(new Dimension(1124, 681));
		panel.setLayout(null);
		contentPane.add(panel);		
		panel.add(Jugador.instancia().getEntidadGrafica().getLabel(), 10, 2);
	}
	
	public void inicializarPanelNivel() {

	        //Inicializando el fondo del juego
	        lblFondo = new JLabel(); 
	        lblFondo.setSize(panel.getSize());
	        lblFondo.setBounds(0, 0, 1130, 710);
	        lblFondo.setIcon(new ImageIcon(new ImageIcon(this.getClass().getClassLoader().getResource(this.fondos[0])).getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_DEFAULT)));
	        panel.add(lblFondo,1, 0);

	        //Inicializando los labels del nivel, la tanda y la carga viral
	        lblTandaActual = new JLabel();
	        lblTandaActual.setBounds(910, -220, 500, 500);
	        lblTandaActual.setText("Tanda actual: 1");
	        lblTandaActual.setFont(new Font("Bahnschrift", Font.BOLD, 26));
	        lblTandaActual.setForeground(Color.WHITE);
	        lblTandaActual.setVisible(true);
	        panel.add(lblTandaActual, 1, 0);
	        
	        lblNivelActual = new JLabel();
	        lblNivelActual.setBounds(910, -180, 500, 500);
	        lblNivelActual.setText("Nivel Actual: 1");
	        lblNivelActual.setFont(new Font("Bahnschrift", Font.BOLD, 26));
	        lblNivelActual.setForeground(Color.WHITE);
	        lblNivelActual.setVisible(true);
	        panel.add(lblNivelActual, 1, 0);
	        
	        lblCargaViral = new JLabel();
	        lblCargaViral.setBounds(910, -140, 500, 500);
	        lblCargaViral.setText("Carga Viral: 0");
	        lblCargaViral.setFont(new Font("Bahnschrift", Font.BOLD, 26));
	        lblCargaViral.setForeground(Color.WHITE);
	        lblCargaViral.setVisible(true);
	        panel.add(lblCargaViral,1,0);

	        //Agregando la barricada
	        lblBarricada = new JLabel();
	        lblBarricada.setBounds(0,300,1124,681);
	        ImageIcon icon = new ImageIcon(new ImageIcon(this.getClass().getClassLoader().getResource("Imagenes/Barricadita.png")).getImage().getScaledInstance(lblFondo.getWidth(), 30, Image.SCALE_SMOOTH));
	        lblBarricada.setIcon(icon);
	        panel.add(lblBarricada,1,0);	       
    }
	
	public void reanudarTodo() {		

		infectados = new MovimientoInfectados(this);
	}
	
	public void insertarEntidad(JLabel label) {
		
		panel.add(label, 10, 2);
		label.setLocation(label.getBounds().getLocation());
		repaint();
	}
	
	public void remover(JLabel lbl) {
		
		panel.remove(lbl);
		lbl.setIcon(null);
		lbl.setVisible(false);
		lbl.repaint();
		panel.revalidate();
		panel.repaint();
	}
	
	public void cambiarNivel(int nivel) {
		
		JOptionPane.showMessageDialog(null, "�Genial! Has avanzado de nivel.", "NUEVO NIVEL", JOptionPane.INFORMATION_MESSAGE);			
		lblNivelActual.setText("Nivel Actual: "+(nivel+1));		
	}
		
	public void ganar() {
		
		JOptionPane.showMessageDialog(null, "�FELICITACIONES! COMPLET� EL JUEGO EXITOSAMENTE.", "GANO", JOptionPane.DEFAULT_OPTION);	
		System.exit(0);
	}
	
	public void perder() {
		
		JOptionPane.showMessageDialog(null, "UPS. HAS PERDIDO. �SUERTE LA PROXIMA!", "PERDI�", JOptionPane.ERROR_MESSAGE);
		System.exit(0);
	}
		
	public void modificarTanda(int tandaActual) {
		
		JOptionPane.showMessageDialog(null, "Cambio de tanda de infectados.", "NUEVA TANDA", JOptionPane.INFORMATION_MESSAGE);	
		lblTandaActual.setText("Tanda actual: "+(tandaActual+1));
	}
	
	public void modificarCargaViral() {
		lblCargaViral.setText("Carga Viral: "+Jugador.instancia().getCargaViral());
	}	
	
	private class Adapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
           movimiento.keyPressed(e, lblFondo);
        }
    }


}
