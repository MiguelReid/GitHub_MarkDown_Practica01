/**
	Datosimg.java
	22 nov 2021 11:47:54
	@author Miguel Reid Ruiz
 */
package programa;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 * @author mikey
 *
 */

public class Datosimg extends JPanel{

	Datos1 datos;
	Imagenes img;
	
	public Datosimg() {
		this.setLayout(new GridLayout(2,1));
		datos = new Datos1();
		img = new Imagenes();
		this.add(datos);
		this.add(img);
		this.setBackground(Color.decode("#ECE2E1"));
		
		//un pequeño JPanel para poder organizar mejor Datos1 con las imagenes
	}
}
