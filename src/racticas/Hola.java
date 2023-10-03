package racticas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Toolkit;

public class Hola {

	 JFrame frmHola;
	 JLabel lblHola;
  String nombre="";
	
	
	public Hola(String nombre) {
		initialize();
		this.nombre=nombre;
		lblHola.setText("Hola "+nombre);
	}
	

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	
	private void initialize() {
		frmHola = new JFrame();
		frmHola.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Alumno\\Downloads\\descarga.jpg"));
		frmHola.setTitle("HOLA");
		frmHola.setBounds(100, 100, 450, 300);
		frmHola.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHola.getContentPane().setLayout(null);
		frmHola.setLocationRelativeTo(null);
		lblHola = new JLabel("");
		lblHola.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblHola.setHorizontalAlignment(SwingConstants.CENTER);
		lblHola.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHola.setBounds(35, 34, 326, 106);
		frmHola.getContentPane().add(lblHola);
	}
}
