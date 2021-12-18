/**
	Extrasniños.java
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
 * The Class Extrasniños.
 *
 * @author mikey
 */
public class Extrasniños extends JPanel {

	/** The edadniños. */
	JLabel edadniños;
	
	/** The edadniñostxt. */
	JTextField edadniñostxt;
	
	/** The spinnerniños. */
	static JSpinner spinnerniños;

	/**
	 * Instantiates a new extrasniños.
	 */
	public Extrasniños() {

		this.setBackground(Color.decode("#ECE2E1"));

		edadniños = new JLabel("Edad de niños: ");
		edadniñostxt = new JTextField("Selecciona la edad");
		edadniñostxt.setEditable(false);
		//editable false para que no se pueda cambiar

		SpinnerNumberModel model5 = new SpinnerNumberModel(1, 0, 10, 1);
		spinnerniños = new JSpinner(model5);
		//modelo para indicar que el maximo valor sea 10, el minimo 0 y que vaya de 1 en 1

		spinnerniños.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				int aux = (Integer) spinnerniños.getValue();
				//si en el spinner tenemos menos de 3 años sera una cuna, si no sera Cama pequeña
				if (aux < 3) {
					edadniñostxt.setText("Cuna");
				} else {
					edadniñostxt.setText("Cama pequeña");
				}
			}
		});

		this.add(edadniños);
		this.add(spinnerniños);
		this.add(edadniñostxt);

	}

}
