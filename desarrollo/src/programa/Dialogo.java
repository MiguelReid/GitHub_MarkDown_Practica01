/**
	Dialogo.java
	21 nov 2021 18:14:07
	@author Miguel Reid Ruiz
 */
package programa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

/**
 * @author mikey
 *
 */

public class Dialogo extends JFrame {

	Botones botones;
	Titulo titulo;
	static JTextArea arrendador, inmueble;
	Datosimg datos;
	Datos2 datos2;
	ImageIcon img;
	Datos1 datos1;

	public Dialogo() {
		super("Alta Pisos");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		img = new ImageIcon(getClass().getResource("/recursos/icono.png"));
		this.setIconImage(img.getImage());
		//el icono que sera el logo de la empresa

		botones = new Botones();
		this.add(botones, BorderLayout.SOUTH);
		titulo = new Titulo();
		this.add(titulo, BorderLayout.NORTH);
		datos = new Datosimg();
		this.add(datos, BorderLayout.WEST);
		datos2 = new Datos2();
		this.add(datos2, BorderLayout.CENTER);
		//añadimos cada JPanel en su respectiva zona

		JTabbedPane pestaña = new JTabbedPane();
		arrendador = new JTextArea();
		inmueble = new JTextArea();

		pestaña.addTab("Datos arrendador", arrendador);
		pestaña.addTab("Datos inmueble", inmueble);
		//cada tab que usaremos para los datos de la persona o del piso
		getContentPane().add(pestaña, BorderLayout.EAST);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screenSize.width, screenSize.height);
		//ponemos el tamaño para que ocupe toda la pantalla
		this.setVisible(true);
		this.setBackground(Color.decode("#ECE2E1"));
	}

}
