package racticas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

public class ColoresRGB {

	private JFrame frmColores;
	private JLabel lblRojo;
	private JSlider sldRojo;
	private JLabel lblVerde;
	private JSlider sldVerde;
	private JLabel lblAzul;
	private JSlider sldAzul;
	private JLabel lblVVerde;
	private JLabel lblVRojo;
	private JLabel lblVAzul;
	private JLabel lblRGB;
	private JLabel lblColor;
	
    int r=0,v=0,a=0;
    
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ColoresRGB window = new ColoresRGB();
					window.frmColores.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public ColoresRGB() {
		initialize();
	}

	public void cambiarColor() 
	{
	    	lblVRojo.setText(""+r);
	    	lblVVerde.setText(""+v);
	    	lblVAzul.setText(""+a);
	    	lblRGB.setText("RGB: ("+r+","+v+","+a+")");
	    	lblColor.setBackground(new Color(r,v,a));
	}
	
	private void initialize() {
		frmColores = new JFrame();
		frmColores.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Alumno\\Downloads\\descarga.jpg"));
		frmColores.setTitle("COLORES");
		frmColores.setBounds(100, 100, 509, 318);
		frmColores.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmColores.getContentPane().setLayout(null);
		frmColores.setLocationRelativeTo(null);
		
		lblRojo = new JLabel("ROJO");
		lblRojo.setFont(new Font("Bauhaus 93", Font.BOLD, 14));
		lblRojo.setBounds(23, 11, 63, 27);
		frmColores.getContentPane().add(lblRojo);
		
		lblVerde = new JLabel("VERDE");
		lblVerde.setFont(new Font("Bauhaus 93", Font.BOLD, 14));
		lblVerde.setBounds(23, 74, 63, 27);
		frmColores.getContentPane().add(lblVerde);
		
		lblAzul = new JLabel("AZUL");
		lblAzul.setFont(new Font("Bauhaus 93", Font.BOLD, 14));
		lblAzul.setBounds(23, 145, 63, 27);
		frmColores.getContentPane().add(lblAzul);
		
		lblRGB = new JLabel("AZUL");
		lblRGB.setFont(new Font("Bauhaus 93", Font.BOLD, 14));
		lblRGB.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblRGB.setHorizontalAlignment(SwingConstants.CENTER);
		lblRGB.setBounds(135, 201, 233, 49);
		frmColores.getContentPane().add(lblRGB);
		
		lblColor = new JLabel("");
		lblColor.setOpaque(true);
		lblColor.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		lblColor.setBounds(297, 29, 168, 161);
		frmColores.getContentPane().add(lblColor);
		
		lblVVerde = new JLabel("0");
		lblVVerde.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblVVerde.setHorizontalAlignment(SwingConstants.CENTER);
		lblVVerde.setBounds(223, 100, 46, 34);
		frmColores.getContentPane().add(lblVVerde);
		
		lblVAzul = new JLabel("0");
		lblVAzul.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblVAzul.setHorizontalAlignment(SwingConstants.CENTER);
		lblVAzul.setBounds(223, 156, 46, 34);
		frmColores.getContentPane().add(lblVAzul);
		
		lblVRojo = new JLabel("0");
		lblVRojo.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblVRojo.setHorizontalAlignment(SwingConstants.CENTER);
		lblVRojo.setBounds(223, 29, 46, 34);
		frmColores.getContentPane().add(lblVRojo);
		
		sldRojo = new JSlider();
		sldRojo.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) 
			{
				r=sldRojo.getValue();
				cambiarColor();
			}
		});
		sldRojo.setMaximum(255);
		sldRojo.setBounds(10, 37, 200, 26);
		frmColores.getContentPane().add(sldRojo);
		
	
		sldVerde = new JSlider();
		sldVerde.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) 
			{
				v=sldVerde.getValue();
				cambiarColor();
			}
		});
		sldVerde.setMaximum(255);
		sldVerde.setBounds(23, 108, 200, 26);
		frmColores.getContentPane().add(sldVerde);
		
		sldAzul = new JSlider();
		sldAzul.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) 
			{
				a=sldAzul.getValue();
				cambiarColor();
			}
		});
		sldAzul.setMaximum(255);
		sldAzul.setBounds(23, 164, 200, 26);
		frmColores.getContentPane().add(sldAzul);
		
		
	}
}
