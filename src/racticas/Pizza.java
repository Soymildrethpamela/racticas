package racticas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Pizza {

	private JFrame frmPizzeriaPalisGheep;
	private JRadioButton radGrande;
	private JRadioButton radFamilia;
	private JRadioButton radJumbo;
	private JRadioButton radIndividual;
	private JLabel lblCantidad;
	private JTextField txtResumen;
	private JLabel lblTotal;
	private JCheckBox chkPapas;
	private JCheckBox chkAlitas;
	private JCheckBox chkPan;
	private JCheckBox chkCoca;
	private JComboBox cmbEspecialidad;
	private JSlider sldCantidad;
	private JButton btnBorrar;
    String especialidad="Mexicana";
    String tamano="Familiar";
    int cantidad =1;
    int total=0;
    int totalComplementos=0;
    int precioPizza=0;
    String c1="",c2="",c3="",c4="";
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pizza window = new Pizza();
					window.frmPizzeriaPalisGheep.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pizza() {
		initialize();
	}
    public void ordenar() 
    {
    	lblCantidad.setText(""+cantidad);
    	switch(tamano) 
    	{
    	case "Familiar":
    		precioPizza=200;
    		break;
    	case "Jumbo":
    		precioPizza=180;
    		break;
    	case "Grande":
    		precioPizza=100;
    		break;
    	case "Individual":
    		precioPizza=80;
    		break;
    	}
    	total=(cantidad*precioPizza)+totalComplementos;
    	txtResumen.setText("\nCANTIDAD\n: " +sldCantidad.getValue()+
    			"\nTAMAÑO: "+tamano +"\n"+
    			"\nESPECIALIDAD: "+ especialidad +"\n"+
    			" \n\nCOMPLEMENTOS\n"+c1+"\n"+c2+"\n"+c3+"\n"+c4);
    	DecimalFormat f = new DecimalFormat("#.00");
    	lblTotal.setText("$ " + f.format(total)+"MXN");
    }
    
    
	private void initialize() {
		frmPizzeriaPalisGheep = new JFrame();
		frmPizzeriaPalisGheep.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Alumno\\Downloads\\descarga (1).jpg"));
		frmPizzeriaPalisGheep.setTitle("PIZZERIA PALIS GHEEP");
		frmPizzeriaPalisGheep.setBounds(100, 100, 679, 517);
		frmPizzeriaPalisGheep.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPizzeriaPalisGheep.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CANTIDAD");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 21, 91, 20);
		frmPizzeriaPalisGheep.getContentPane().add(lblNewLabel);
		
		sldCantidad = new JSlider();
		sldCantidad.setValue(1);
		sldCantidad.setMinimum(1);
		sldCantidad.setMaximum(10);
		
		sldCantidad.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				cantidad=sldCantidad.getValue();
				ordenar();
			}
		});
		sldCantidad.setBounds(10, 52, 200, 26);
		frmPizzeriaPalisGheep.getContentPane().add(sldCantidad);
		
		JLabel lblNewLabel_1 = new JLabel("ESPECIALIDAD");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 96, 91, 20);
		frmPizzeriaPalisGheep.getContentPane().add(lblNewLabel_1);
		
		cmbEspecialidad = new JComboBox();
		cmbEspecialidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				especialidad=String.valueOf(cmbEspecialidad.getSelectedItem());
				ordenar();
			}
		});
		cmbEspecialidad.setModel(new DefaultComboBoxModel(new String[] {"MEXICANA", "PEPERONI", "JAMON CON QUESO", "CUATRO QUESO"}));
		cmbEspecialidad.setBounds(10, 127, 155, 26);
		frmPizzeriaPalisGheep.getContentPane().add(cmbEspecialidad);
		
		JLabel lblNewLabel_2 = new JLabel("TAMAÑO");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 171, 91, 20);
		frmPizzeriaPalisGheep.getContentPane().add(lblNewLabel_2);
		
		radFamilia = new JRadioButton("FAMILIAR");
		radFamilia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radFamilia.isSelected()) 
				{
					tamano="Familiar";
				}
				ordenar();
			}
		});
		radFamilia.setFont(new Font("Tahoma", Font.BOLD, 11));
		radFamilia.setBounds(10, 198, 155, 20);
		frmPizzeriaPalisGheep.getContentPane().add(radFamilia);
		
		radJumbo = new JRadioButton("JUMBO");
		radJumbo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radJumbo.isSelected()) 
				{
					tamano="Jumbo";
				}
				ordenar();
				
			}
		});
		radJumbo.setFont(new Font("Tahoma", Font.BOLD, 11));
		radJumbo.setBounds(10, 223, 109, 23);
		frmPizzeriaPalisGheep.getContentPane().add(radJumbo);
		
		radGrande = new JRadioButton("GRANDE");
		radGrande.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radGrande.isSelected()) 
				{
					tamano="Grande";
				}
				ordenar();
				
			}
		});
		radGrande.setFont(new Font("Tahoma", Font.BOLD, 11));
		radGrande.setBounds(10, 249, 155, 23);
		frmPizzeriaPalisGheep.getContentPane().add(radGrande);
		
		radIndividual = new JRadioButton("INDIVIDUAL");
		radIndividual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radIndividual.isSelected()) 
				{
					tamano="Individual";
				}
				ordenar();
			}
			
			
		});
		radIndividual.setFont(new Font("Tahoma", Font.BOLD, 11));
		radIndividual.setBounds(10, 275, 109, 23);
		frmPizzeriaPalisGheep.getContentPane().add(radIndividual);
		ButtonGroup grupo= new ButtonGroup();
		grupo.add(radFamilia);
		grupo.add(radJumbo);
		grupo.add(radGrande);
		grupo.add(radIndividual);
		
		JLabel lblNewLabel_3 = new JLabel("PIZZERIA PAMLIS");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_3.setBounds(169, 11, 173, 20);
		frmPizzeriaPalisGheep.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Alumno\\Downloads\\descarga (1).jpg"));
		lblNewLabel_4.setBounds(366, 11, 225, 213);
		frmPizzeriaPalisGheep.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("COMPLEMENTO");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(10, 307, 109, 26);
		frmPizzeriaPalisGheep.getContentPane().add(lblNewLabel_5);
		
		chkPapas = new JCheckBox("PAPAS ALA FRANCESA");
		chkPapas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chkPapas.isSelected()) {
					totalComplementos+=70;
					c1="unas papas";
					
				}else {
					totalComplementos-=70;
					c1="";
				}
				ordenar();
			}
		});
		chkPapas.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkPapas.setBounds(10, 340, 155, 23);
		frmPizzeriaPalisGheep.getContentPane().add(chkPapas);
		
		chkAlitas = new JCheckBox("ALITAS");
		chkAlitas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chkAlitas.isSelected()) {
					totalComplementos+=80;
					c2="unas alitas";
					
				}else {
					totalComplementos-=80;
					c2="";
				}
				ordenar();
				
			}
			
		});
		chkAlitas.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkAlitas.setBounds(10, 371, 97, 23);
		frmPizzeriaPalisGheep.getContentPane().add(chkAlitas);
		
		chkPan = new JCheckBox("PAN");
		chkPan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(chkPan.isSelected()) {
					totalComplementos+=50;
					c3="uno pan";
					
				}else {
					totalComplementos-=50;
					c3="";
				}
				ordenar();
			}
		});
		chkPan.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkPan.setBounds(10, 397, 97, 23);
		frmPizzeriaPalisGheep.getContentPane().add(chkPan);
		
		chkCoca = new JCheckBox("COCA");
		chkCoca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chkCoca.isSelected()) {
					totalComplementos+=30;
					c4="una coca";
					
				}else {
					totalComplementos-=30;
					c4="";
				}
				ordenar();
				
			}
		});
		chkCoca.setFont(new Font("Tahoma", Font.BOLD, 11));
		chkCoca.setBounds(10, 423, 97, 23);
		frmPizzeriaPalisGheep.getContentPane().add(chkCoca);
		
		btnBorrar = new JButton("BORRAR");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sldCantidad.setValue(1);
				cmbEspecialidad.setSelectedIndex(0);
				radJumbo.setSelected(false);
				radFamilia.setSelected(true);
				radGrande.setSelected(false);
				radIndividual.setSelected(false);
				chkPapas.setSelected(false);
				chkAlitas.setSelected(false);
				chkCoca.setSelected(false);
				chkPan.setSelected(false);
				txtResumen.setText("");
				lblCantidad.setText("1");
				lblTotal.setText("$ 0.0 MXN");
			}
		});
		btnBorrar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBorrar.setBounds(176, 171, 146, 53);
		frmPizzeriaPalisGheep.getContentPane().add(btnBorrar);
		
		JLabel lblNewLabel_6 = new JLabel("RESUMEN DE LA ORDEN");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6.setBounds(188, 253, 186, 19);
		frmPizzeriaPalisGheep.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("TOTAL");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_7.setBounds(514, 236, 128, 37);
		frmPizzeriaPalisGheep.getContentPane().add(lblNewLabel_7);
		
		lblCantidad = new JLabel("");
		lblCantidad.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCantidad.setBounds(234, 52, 35, 26);
		frmPizzeriaPalisGheep.getContentPane().add(lblCantidad);
		
		txtResumen = new JTextField();
		txtResumen.setBounds(169, 284, 304, 135);
		frmPizzeriaPalisGheep.getContentPane().add(txtResumen);
		txtResumen.setColumns(10);
		
		lblTotal = new JLabel("");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTotal.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblTotal.setBounds(487, 296, 155, 53);
		frmPizzeriaPalisGheep.getContentPane().add(lblTotal);
	}
}
