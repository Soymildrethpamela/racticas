package racticas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class Barrita {

	private JFrame frmBarrraDeProgreso;
	private JProgressBar barraProgreso;
	private JButton btnStart;
    String nombre="";
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Barrita window = new Barrita();
					window.frmBarrraDeProgreso.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Barrita() {
		initialize();
	}
public void start() {
	nombre=JOptionPane.showInputDialog("ESCRIBE TU NOMBRE");
	Thread hilo=new Thread (new Runnable() {
		
		public void run() {
			for(int  i=0; i<=100; i++) {
				barraProgreso.setValue(i);
				try{
					Thread.sleep(10);
				}catch (InterruptedException e) {
					e.printStackTrace();
					
				}
				if(i==100) {
					Hola hola=new Hola (nombre);
					hola.frmHola.show(true);
					frmBarrraDeProgreso.show(false);
				}
			}
			
		}
		
	});
	hilo.start();
}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBarrraDeProgreso = new JFrame();
		frmBarrraDeProgreso.getContentPane().setBackground(new Color(255, 255, 255));
		frmBarrraDeProgreso.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Alumno\\Downloads\\descarga.jpg"));
		frmBarrraDeProgreso.setTitle("BARRRA DE PROGRESO");
		frmBarrraDeProgreso.setBounds(100, 100, 450, 300);
		frmBarrraDeProgreso.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBarrraDeProgreso.getContentPane().setLayout(null);
		frmBarrraDeProgreso.setLocationRelativeTo(null);
		barraProgreso = new JProgressBar();
		barraProgreso.setForeground(new Color(255, 0, 0));
		barraProgreso.setFont(new Font("Tahoma", Font.BOLD, 20));
		barraProgreso.setStringPainted(true);
		barraProgreso.setBounds(88, 33, 241, 49);
		frmBarrraDeProgreso.getContentPane().add(barraProgreso);
		
		btnStart = new JButton("START");
		btnStart.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				start();
			}
		});
		btnStart.setBounds(126, 143, 181, 22);
		frmBarrraDeProgreso.getContentPane().add(btnStart);
	}
}
