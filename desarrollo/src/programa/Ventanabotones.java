/**
	Ventanabotones.java
	22 nov 2021 10:28:01
	@author Miguel Reid Ruiz
 */
package programa;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author mikey
 *
 */
public class Ventanabotones extends JPanel{

	JButton uno, dos;
	
	/**
	 * Instantiates a new ventanabotones.
	 */
	public Ventanabotones() {
		this.setBackground(Color.decode("#fec89a"));

		uno = new JButton("");
		dos = new JButton("");
		
		try {
			Image img = ImageIO.read(getClass().getResource("/recursos/casa1.png"));
			uno.setIcon(new ImageIcon(img));
			Image img2 = ImageIO.read(getClass().getResource("/recursos/casa2.png"));
			dos.setIcon(new ImageIcon(img2));
			//imagenes siempre siguiendo las normas de usabilidad con un lapiz y menos para indicar dar de alta y de baja
		} catch (Exception ex) {
			System.out.println(ex);
		}
			
		this.add(uno);
		this.add(dos);
	}
}
