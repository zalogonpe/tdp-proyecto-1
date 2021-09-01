package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JLabel etiquetaLU, etiquetaApellido, etiquetaNombre, etiquetaMail, etiquetaURL, etiquetaFoto, etiquetaFecha;
	private JTextField textoLU, textoApellido, textoNombre, textoMail, textoURL;
	private Calendar fecha;

	public SimplePresentationScreen(Student studentData) {
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");
		setIconImage(new ImageIcon(SimplePresentationScreen.class.getResource("/images/tdp.png")).getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 250));
		setResizable(false);
		setContentPane(contentPane);
		init();
	}
	
	private void init() {
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		contentPane.add(tabbedPane, BorderLayout.WEST);
		
		etiquetaLU=new JLabel("LU: ");
		etiquetaApellido=new JLabel("Apellido: ");
		etiquetaNombre=new JLabel("Nombre: ");
		etiquetaMail=new JLabel("E-mail: ");
		etiquetaURL=new JLabel("GitHub URL: ");
		textoLU=new JTextField(studentData.getId()+""); textoLU.setEditable(false); textoLU.setBackground(Color.WHITE);
		textoApellido=new JTextField(studentData.getLastName()); textoApellido.setEditable(false); textoApellido.setBackground(Color.WHITE);
		textoNombre=new JTextField(studentData.getFirstName()); textoNombre.setEditable(false); textoNombre.setBackground(Color.WHITE);
		textoMail=new JTextField(studentData.getMail()); textoMail.setEditable(false); textoMail.setBackground(Color.WHITE);
		textoURL=new JTextField(studentData.getGithubURL()); textoURL.setEditable(false); textoURL.setBackground(Color.WHITE);
		
		GroupLayout layout=new GroupLayout(tabInformation);
		layout.setHorizontalGroup(layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup()
									.addComponent(etiquetaLU)
									.addComponent(etiquetaApellido)
									.addComponent(etiquetaNombre)
									.addComponent(etiquetaMail)
									.addComponent(etiquetaURL)
								).addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup()
									.addComponent(textoLU)
									.addComponent(textoApellido)
									.addComponent(textoNombre)
									.addComponent(textoMail)
									.addComponent(textoURL)
								).addContainerGap()
						)
		);
		layout.setVerticalGroup(layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup()
									.addComponent(etiquetaLU).addComponent(textoLU)
								).addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup()
									.addComponent(etiquetaApellido).addComponent(textoApellido)
								).addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup()
									.addComponent(etiquetaNombre).addComponent(textoNombre)
								).addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup()
									.addComponent(etiquetaMail).addComponent(textoMail)
								).addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup()
									.addComponent(etiquetaURL).addComponent(textoURL)
								).addContainerGap()
						)
		);
		tabInformation.setLayout(layout);
		
		etiquetaFoto=new JLabel(new ImageIcon(SimplePresentationScreen.class.getResource("/images/Gonzalo.png")));
		etiquetaFoto.setPreferredSize(new Dimension(155, 200));
		contentPane.add(etiquetaFoto, BorderLayout.EAST);
		
		fecha=Calendar.getInstance();
		etiquetaFecha=new JLabel("Esta ventana fue generada el "+LocalDate.now().getDayOfMonth()+"/"
				+LocalDate.now().getMonthValue()+"/"+LocalDate.now().getYear()+" a las "
				+fecha.get(Calendar.HOUR_OF_DAY)+":"+fecha.get(Calendar.MINUTE)+":"
				+fecha.get(Calendar.SECOND));
		contentPane.add(etiquetaFecha, BorderLayout.SOUTH);
	}
}