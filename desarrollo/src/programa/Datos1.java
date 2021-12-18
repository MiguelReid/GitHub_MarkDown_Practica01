/**
	Datos1.java
	21 nov 2021 18:26:43
	@author Miguel Reid Ruiz
 */
package programa;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

/**
 * @author mikey
 *
 */
public class Datos1 extends JPanel implements ActionListener {

	JLabel nombre, apellido, dni, telefono;
	JTextField nombretxt, apellidotxt;
	MaskFormatter mascaraTexto, mascaraTexto2;
	JFormattedTextField cajaDeTexto, cajaDeTexto2;

	public Datos1() {

		this.setLayout(new GridLayout(4, 2, 10, 10));
		this.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode("#FFBF86")));
		//ponemos un borde de grosor 2

		nombre = new JLabel("Nombre: ");
		nombretxt = new JTextField("");

		nombre.setFont(new Font("Serif", Font.BOLD, 30));
		nombre.setForeground(Color.decode("#FFBF86"));

		apellido = new JLabel("Apellido: ");
		apellidotxt = new JTextField("");
		apellido.setFont(new Font("Serif", Font.BOLD, 30));
		apellido.setForeground(Color.decode("#FFBF86"));

		dni = new JLabel("Dni: ");
		dni.setFont(new Font("Serif", Font.BOLD, 30));
		dni.setForeground(Color.decode("#FFBF86"));

		telefono = new JLabel("Telefono: ");
		telefono.setFont(new Font("Serif", Font.BOLD, 30));
		telefono.setForeground(Color.decode("#FFBF86"));
		
		//creamos JLabel y TextField con sus diseños para que sea mas llamativo

		try {
			mascaraTexto = new MaskFormatter("#########");
			cajaDeTexto = new JFormattedTextField(mascaraTexto);
			cajaDeTexto.setFocusLostBehavior(cajaDeTexto.COMMIT);
			cajaDeTexto.setHorizontalAlignment(SwingConstants.CENTER);
			//los 9# significa que solo podran ser 9 numeros

		} catch (ParseException eu1) {
			eu1.printStackTrace();
		}

		try {
			mascaraTexto2 = new MaskFormatter("########U");
			cajaDeTexto2 = new JFormattedTextField(mascaraTexto2);
			cajaDeTexto2.setFocusLostBehavior(cajaDeTexto2.COMMIT);
			cajaDeTexto2.setHorizontalAlignment(SwingConstants.CENTER);
			//Para el DNI obligamos a que sean 8 numeros y una letra en mayuscula al final siempre

		} catch (ParseException eu1) {
			eu1.printStackTrace();
		}

		this.add(nombre);
		this.add(nombretxt);
		this.add(apellido);
		this.add(apellidotxt);
		this.add(dni);
		this.add(cajaDeTexto2);
		this.add(telefono);
		this.add(cajaDeTexto);
		this.setBackground(Color.decode("#ECE2E1"));
		//color de fondo, se puede usar Color.RED por ejemplo pero me parece mas
		//preciso usar el HEX triplet

		Botones.guardar.addActionListener(this);
		Botones.nuevo.addActionListener(this);
		Botones.print.addActionListener(this);
		//añadimos action listener ya que si no no funcionara
	}

	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == Botones.guardar) {
			System.out.println("Hola");
			if (nombretxt.getText().equals("") | apellidotxt.getText().equals("") | cajaDeTexto.getText().equals("")
					| cajaDeTexto2.getText().equals("") | Datos2.direccion.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "FALTAN DATOS", "WARNING", JOptionPane.INFORMATION_MESSAGE);
				//Si los campos estan vacios me salta un aviso
			} else {
				nombretxt.setText("");
				apellidotxt.setText("");
				cajaDeTexto.setText("");
				cajaDeTexto2.setText("");
				Datos2.direccion.setText("");
				//si no estan vacios me los vacia y me dice que los registros han sido guardados

				JOptionPane.showMessageDialog(null, "REGISTROS GUARDADOS", "INFORMACION",
						JOptionPane.INFORMATION_MESSAGE);
			}

		}

		if (e.getSource() == Botones.nuevo) {
			
			nombretxt.requestFocus();
			
			nombretxt.setText("");
			apellidotxt.setText("");
			cajaDeTexto.setText("");
			cajaDeTexto2.setText("");
			Datos2.direccion.setText("");
			Datos2.huespedes.setValue(Integer.valueOf(1));
			Datos2.dormitorios.setValue(Integer.valueOf(1));
			Datos2.baños.setValue(Integer.valueOf(1));
			Datos2.camas.setValue(Integer.valueOf(1));
			Extrasniños.spinnerniños.setValue(Integer.valueOf(1));
			Datos2.box.setSelectedIndex(0);
			Datos2.box2.setSelectedIndex(0);

			SpinnerModel model11 = new SpinnerDateModel();
			Datos2.spinner = new JSpinner(model11);
			Datos2.spinner.setEditor(new JSpinner.DateEditor(Datos2.spinner, "dd-MM-yyyy"));

			SpinnerModel model111 = new SpinnerDateModel();
			Datos2.spinner2 = new JSpinner(model111);
			Datos2.spinner2.setEditor(new JSpinner.DateEditor(Datos2.spinner2, "dd-MM-yyyy"));

			Dialogo.arrendador.setText("");
			Dialogo.inmueble.setText("");
			//ponemos todo a su valor inicial

			Datos2.niños.addActionListener(this);
		}

		if (e.getSource() == Botones.print) {

			if (nombretxt.getText().equals("") | apellidotxt.getText().equals("") | cajaDeTexto.getText().equals("")
					| cajaDeTexto2.getText().equals("") | Datos2.direccion.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "FALTAN DATOS", "WARNING", JOptionPane.INFORMATION_MESSAGE);
				//para imprimir vemos primero que no esten vacios
			} else {
				
				String nombre = nombretxt.getText();
				String apellido = apellidotxt.getText();
				String dni = cajaDeTexto.getText();
				String telefono = cajaDeTexto2.getText();
				String direccion = Datos2.direccion.getText();
				Dialogo.arrendador.setText("Nombre: " + nombre + "\n Apellido: " + apellido + "\n Dni: " + dni
						+ "\n Telefono: " + telefono + "\n Direccion: " + direccion);
				//ponemos el texto con las variables que hemos introducido en los JTextArea
				String fecha1 = new SimpleDateFormat("dd/MM/yyyy").format(Datos2.spinner.getValue());
				String fecha2 = new SimpleDateFormat("dd/MM/yyyy").format(Datos2.spinner2.getValue());
				int huespedes = (Integer) Datos2.huespedes.getValue();
				int dormitorios = (Integer) Datos2.dormitorios.getValue();
				int baños = (Integer) Datos2.baños.getValue();
				int camas = (Integer) Datos2.camas.getValue();
				String box = Datos2.box.getSelectedItem().toString();
				String box2 = Datos2.box2.getSelectedItem().toString();
				//cogemos los valores te cada Component para ponerlo en el TabedPane

				String niños;

				if (Datos2.niños.isSelected()) {
					niños = "Si hay niños";
				} else {
					niños = "No hay niños";
				}
				//algo sencillo para que no devuelva un valor booleano, sino que sea un string diciendo
				//si hay o no niños

				Dialogo.inmueble.setText("Fecha llegada: " + fecha1 + "\n Fecha salida: " + fecha2 + "\n Huespedes: "
						+ huespedes + "\n Dormitorios: " + dormitorios + "\n Baños: " + baños + "\n Camas: " + camas
						+ "\nTipo camas: " + box2 + "\nCiudad: " + box + "\n" + niños);
				
				//igual que antes ponemos los datos de las variables que cogemos
			}
		}
	}
}
