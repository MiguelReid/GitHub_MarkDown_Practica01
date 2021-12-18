/**
	Logo.java
	21 nov 2021 18:18:14
	@author Miguel Reid Ruiz
 */
package programa;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author mikey
 *
 */
public class Titulo extends JPanel{

	JLabel titulo;
	
	/**
	 * Instantiates a new titulo.
	 */
	public Titulo() {
		titulo = new JLabel("DulceSol");
		titulo.setFont(new Font("Serif", Font.BOLD, 80));
		titulo.setForeground(Color.decode("#C37B89"));
		this.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.decode("#C37B89")));
		this.setBackground(Color.decode("#ECE2E1"));
		//Clase para el titulo que este en grande con un borde de color 
		this.add(titulo);
	}
}
