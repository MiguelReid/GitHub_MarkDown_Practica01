/**
	Images.java
	21 nov 2021 18:24:58
	@author Miguel Reid Ruiz
 */
package programa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author mikey
 *
 */
public class Imagenes extends JPanel implements ActionListener {

	JButton boton;
	int aux;

	/**
	 * Instantiates a new imagenes.
	 */
	public Imagenes() {
		
		//aqui tendremos las tres imagenes en el boton, si lo clickas va cambiando
		//usamos un auxiliar a modo de flag viendo que valor tiene cambiara la imagen
		//con un orden que yo quiera

		this.setBackground(Color.decode("#ECE2E1"));

		this.setBorder(BorderFactory.createEtchedBorder());
		aux = 0;

		this.setLayout(new BorderLayout());

		boton = new JButton();
		boton.addActionListener(this);
		
		boton.setToolTipText("Hac click para cambiar imagen");

		try {
			// ruta de nuestra imagen
			Image img = ImageIO.read(getClass().getResource("/recursos/ventana.jpg"));
			boton.setIcon(new ImageIcon(img));
			//En un inicio tendremos la imagen ventana por lo cual abajo sera la ultima en aparecer para que esten en orden

		} catch (Exception ex) {
			System.out.println(ex);
		}
		this.add(boton, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent evento) {

		if (evento.getSource() == boton) {

			if (aux == 0) {
				// el check para saber si encriptar o no la informacion dependiendo de la foto
				try {
					Image img2 = ImageIO.read(getClass().getResource("/recursos/habitacion.jpg"));
					boton.setIcon(new ImageIcon(img2));
					aux = 1;
					//aux a 1 para que cambie la foto y asi sucesivamente hasta 2
					System.out.println(aux);
				} catch (Exception ex) {
					System.out.println(ex);
				}
			} else {
				if (aux == 1) {
					// el check para saber si encriptar o no la informacion dependiendo de la foto
					try {
						Image img2 = ImageIO.read(getClass().getResource("/recursos/habitacion2.jpg"));
						boton.setIcon(new ImageIcon(img2));
						aux = 2;
						System.out.println(aux);

					} catch (Exception ex) {
						System.out.println(ex);
					}
				} else {
					if (aux == 2) {
						// el check para saber si encriptar o no la informacion dependiendo de la foto
						try {
							Image img2 = ImageIO.read(getClass().getResource("/recursos/ventana.jpg"));
							boton.setIcon(new ImageIcon(img2));
							aux = 0;
							System.out.println(aux);

						} catch (Exception ex) {
							System.out.println(ex);
						}
					}
				}
			}

		}

	}
}
