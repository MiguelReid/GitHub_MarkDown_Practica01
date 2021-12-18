/**
	Extrasni�os.java
	23 nov 2021 10:18:38
	@author Miguel Reid Ruiz
 */
package programa;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

// TODO: Auto-generated Javadoc
/**
 * The Class Extrasni�os.
 *
 * @author mikey
 */
public class Extrasni�os extends JPanel {

	/** The edadni�os. */
	JLabel edadni�os;
	
	/** The edadni�ostxt. */
	JTextField edadni�ostxt;
	
	/** The spinnerni�os. */
	static JSpinner spinnerni�os;

	/**
	 * Instantiates a new extrasni�os.
	 */
	public Extrasni�os() {

		this.setBackground(Color.decode("#ECE2E1"));

		edadni�os = new JLabel("Edad de ni�os: ");
		edadni�ostxt = new JTextField("Selecciona la edad");
		edadni�ostxt.setEditable(false);
		//editable false para que no se pueda cambiar

		SpinnerNumberModel model5 = new SpinnerNumberModel(1, 0, 10, 1);
		spinnerni�os = new JSpinner(model5);
		//modelo para indicar que el maximo valor sea 10, el minimo 0 y que vaya de 1 en 1

		spinnerni�os.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				int aux = (Integer) spinnerni�os.getValue();
				//si en el spinner tenemos menos de 3 a�os sera una cuna, si no sera Cama peque�a
				if (aux < 3) {
					edadni�ostxt.setText("Cuna");
				} else {
					edadni�ostxt.setText("Cama peque�a");
				}
			}
		});

		this.add(edadni�os);
		this.add(spinnerni�os);
		this.add(edadni�ostxt);

	}

}
