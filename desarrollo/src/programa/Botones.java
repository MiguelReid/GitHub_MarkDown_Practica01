/**
	Botones.java
	21 nov 2021 18:30:29
	@author Miguel Reid Ruiz
 */
package programa;

import java.awt.Color;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author mikey
 *
 */

public class Botones extends JPanel {

	static JButton guardar, nuevo, print;

	public Botones() {
		
		nuevo = new JButton("");
		print = new JButton("");
		guardar = new JButton("");

		try {
			Image img = ImageIO.read(getClass().getResource("/recursos/nuevo.png"));
			nuevo.setIcon(new ImageIcon(img));
			Image img2 = ImageIO.read(getClass().getResource("/recursos/print.png"));
			print.setIcon(new ImageIcon(img2));
			Image img3 = ImageIO.read(getClass().getResource("/recursos/guardar.png"));
			guardar.setIcon(new ImageIcon(img3));
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		//Tenemos tres botones que añaderemos al JFrame principal al sur, cada uno con sus imagenes segun 
		//normas de usabilidad, son static para que se accedan desde Datos1
		this.add(nuevo);
		this.add(print);
		this.add(guardar);
		this.setBackground(Color.decode("#ECE2E1"));

	}
}
