/**
	Ventananorte.java
	23 nov 2021 12:05:11
	@author Miguel Reid Ruiz
 */
package programa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author mikey
 *
 */
public class Ventananorte extends JPanel{
	JLabel logo;
	
	/**
	 * Instantiates a new ventananorte.
	 */
	public Ventananorte() {
		this.setLayout(new BorderLayout());
		this.setBackground(Color.decode("#d6e2e9"));

		logo = new JLabel();
		try {
			Image img = ImageIO.read(getClass().getResource("/recursos/logo.png"));
			//Una clase para tener el logo en grande
			logo.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		this.add(logo, BorderLayout.CENTER);
	}
}
