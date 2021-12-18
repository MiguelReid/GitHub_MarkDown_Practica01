/**
	Datos2.java
	21 nov 2021 18:27:00
	@author Miguel Reid Ruiz
 */
package programa;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.MaskFormatter;

/**
 * @author mikey
 *
 */
public class Datos2 extends JPanel implements ActionListener {

	MaskFormatter mascara2;
	static JSpinner huespedes, dormitorios, baños, camas, spinner2, spinner;
	static JComboBox<String> box, box2;
	JLabel direcciontxt, provincia, fecha_alta, fecha_final, huespedestxt, dormitoriostxt, bañostxt, camastxt,
			tipo_camas, niñostxt, extras_niños, edadniños;
	JLabel preciominimo;
	static JCheckBox niños;
	static JTextField direccion;
	JTextField edadniñostxt;
	boolean flag;
	static Extrasniños extrasniños;
	int precio1, precio2, precio3, precio4, precio5;

	/**
	 * Instantiates a new datos 2.
	 */
	public Datos2() {

		this.setBackground(Color.decode("#ECE2E1"));
		this.setLayout(new GridLayout(11, 2, 30, 30));
		this.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.decode("#FFA0A0")));

		direcciontxt = new JLabel("Direccion");
		direcciontxt.setFont(new Font("Serif", Font.BOLD, 30));
		direcciontxt.setForeground(Color.decode("#FFA0A0"));
		provincia = new JLabel("Provincia");
		provincia.setFont(new Font("Serif", Font.BOLD, 30));
		provincia.setForeground(Color.decode("#FFA0A0"));
		fecha_alta = new JLabel("Fecha de Alta");
		fecha_alta.setFont(new Font("Serif", Font.BOLD, 30));
		fecha_alta.setForeground(Color.decode("#FFA0A0"));
		fecha_final = new JLabel("Fecha Final");
		fecha_final.setFont(new Font("Serif", Font.BOLD, 30));
		fecha_final.setForeground(Color.decode("#FFA0A0"));
		huespedestxt = new JLabel("Numero Huespedes: ");
		huespedestxt.setFont(new Font("Serif", Font.BOLD, 30));
		huespedestxt.setForeground(Color.decode("#FFA0A0"));
		dormitoriostxt = new JLabel("Numero Dormitorios: ");
		dormitoriostxt.setFont(new Font("Serif", Font.BOLD, 30));
		dormitoriostxt.setForeground(Color.decode("#FFA0A0"));
		bañostxt = new JLabel("Numero Baños: ");
		bañostxt.setFont(new Font("Serif", Font.BOLD, 30));
		bañostxt.setForeground(Color.decode("#FFA0A0"));
		camastxt = new JLabel("Numero Camas: ");
		camastxt.setFont(new Font("Serif", Font.BOLD, 30));
		camastxt.setForeground(Color.decode("#FFA0A0"));
		tipo_camas = new JLabel("Tipo de Camas: ");
		tipo_camas.setFont(new Font("Serif", Font.BOLD, 30));
		tipo_camas.setForeground(Color.decode("#FFA0A0"));
		niñostxt = new JLabel("¿Niños?");
		niñostxt.setFont(new Font("Serif", Font.BOLD, 30));
		niñostxt.setForeground(Color.decode("#FFA0A0"));
		extras_niños = new JLabel("Extras Niños: ");
		extras_niños.setFont(new Font("Serif", Font.BOLD, 30));
		extras_niños.setForeground(Color.decode("#FFA0A0"));

		preciominimo = new JLabel();

		preciominimo
				.setText("<html> Por cama doble: " + precio1 + " | Por sofa cama: " + precio2 + "<br/>Por cama simple: "
						+ precio3 + " | Por baño: " + precio4 + " | Cuna o cama supletoria: " + precio5 + "</html>");

		preciominimo.setToolTipText("si haces click muestro los precios");

		preciominimo.setFont(new Font("Serif", Font.BOLD, 15));
		preciominimo.setForeground(Color.decode("#FFA0A0"));

		preciominimo.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				precio1 = 20;
				precio2 = 15;
				precio3 = 15;
				precio4 = 25;
				precio5 = 12;
				preciominimo.setText("<html> Por cama doble: " + precio1 + " | Por sofa cama: " + precio2
						+ "<br/>Por cama simple: " + precio3 + " | Por baño: " + precio4 + " | Cuna o cama supletoria: "
						+ precio5 + "</html>");
				//si clickamos el JLabel se pondra el precio, he tenido que usar el html
				//ya que usando \n no me hacia el salto de linea.
			}
		});

		direccion = new JTextField("");

		SpinnerNumberModel model = new SpinnerNumberModel(1, 1, 8, 1);
		//como maximo aceptaremos 8 y minimo 1
		huespedes = new JSpinner(model);

		JComponent editor = huespedes.getEditor();
		JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) editor;
		spinnerEditor.getTextField().setHorizontalAlignment(JTextField.CENTER);

		SpinnerNumberModel model2 = new SpinnerNumberModel(1, 1, 4, 1);
		dormitorios = new JSpinner(model2);

		JComponent editor2 = dormitorios.getEditor();
		JSpinner.DefaultEditor spinnerEditor2 = (JSpinner.DefaultEditor) editor2;
		spinnerEditor2.getTextField().setHorizontalAlignment(JTextField.CENTER);

		SpinnerNumberModel model3 = new SpinnerNumberModel(1, 1, 2, 1);
		baños = new JSpinner(model3);

		JComponent editor3 = baños.getEditor();
		JSpinner.DefaultEditor spinnerEditor3 = (JSpinner.DefaultEditor) editor3;
		spinnerEditor3.getTextField().setHorizontalAlignment(JTextField.CENTER);

		SpinnerNumberModel model4 = new SpinnerNumberModel(1, 1, 4, 1);
		//step, valor maximo y minimo al final
		camas = new JSpinner(model4);

		JComponent editor4 = camas.getEditor();
		JSpinner.DefaultEditor spinnerEditor4 = (JSpinner.DefaultEditor) editor4;
		spinnerEditor4.getTextField().setHorizontalAlignment(JTextField.CENTER);

		niños = new JCheckBox("¿Niños?");
		niños.setBackground(Color.decode("#ECE2E1"));

		extrasniños = new Extrasniños();
		extrasniños.setVisible(false);
		//invisible inicialmente hasta que activen el checkbox

		SpinnerModel model1 = new SpinnerDateModel();
		spinner = new JSpinner(model1);
		spinner.setEditor(new JSpinner.DateEditor(spinner, "dd-MM-yyyy"));
		//modelo para que este en formato dia-mes-año

		JComponent editor5 = spinner.getEditor();
		JSpinner.DefaultEditor spinnerEditor5 = (JSpinner.DefaultEditor) editor5;
		spinnerEditor5.getTextField().setHorizontalAlignment(JTextField.CENTER);
		//para poner el texto en el centro que queda mas elegante

		SpinnerModel model11 = new SpinnerDateModel();
		spinner2 = new JSpinner(model11);
		spinner2.setEditor(new JSpinner.DateEditor(spinner2, "dd-MM-yyyy"));

		JComponent editor6 = spinner2.getEditor();
		JSpinner.DefaultEditor spinnerEditor6 = (JSpinner.DefaultEditor) editor6;
		spinnerEditor6.getTextField().setHorizontalAlignment(JTextField.CENTER);

		box = new JComboBox<String>();
		box.setToolTipText("Elige la Provincia");
		box.addItem("Madrid");
		box.addItem("Barcelona");
		box.addItem("Valencia");
		box.addItem("Sevilla");
		box.addItem("Alicante");
		box.addItem("Malaga");
		box.addItem("Murcia");
		box.addItem("Cadiz");
		box.addItem("Vizcaya");
		box.addItem("A coruña");
		box.addItem("Las Palmas");
		box.addItem("Baleares");
		box.addItem("Asturias");
		box.addItem("Tenerife");
		box.addItem("Zaragoza");
		box.addItem("Pontevedra");
		box.addItem("Granada");
		box.addItem("Tarragona");
		box.addItem("Cordoba");
		box.addItem("Gerona");
		box.addItem("Guipuzcua");
		box.addItem("Almeria ;)");
		box.addItem("Toledo");
		box.addItem("Badajoz");
		box.addItem("Jaen");
		box.addItem("Navarra");
		box.addItem("Cantabria");
		box.addItem("Castellon");
		box.addItem("Valladolid");
		box.addItem("Ciudad Real");
		box.addItem("Huelva");
		box.addItem("Leon");
		box.addItem("Lerida");
		box.addItem("Caceres");
		box.addItem("Albacete");
		box.addItem("Burgos");
		box.addItem("Lugo");
		box.addItem("Salamanca");
		box.addItem("Ourense");
		box.addItem("Alava");
		box.addItem("La Rioja");
		box.addItem("Guadalajara");
		box.addItem("Huesca");
		box.addItem("Cuenca");
		box.addItem("Zamora");
		box.addItem("Palencia");
		box.addItem("Avila");
		box.addItem("Segovia");
		box.addItem("Teruel");
		box.addItem("Soria");
		box.addItem("Ceuta");
		box.addItem("Melilla");
		box.setEditable(false);

		box2 = new JComboBox<String>();
		box2.addItem("Simple");
		box2.addItem("Sofa Cama");

		this.add(direcciontxt);
		this.add(direccion);

		this.add(fecha_alta);
		this.add(spinner);

		this.add(fecha_final);
		this.add(spinner2);

		this.add(huespedestxt);
		this.add(huespedes);

		this.add(dormitoriostxt);
		this.add(dormitorios);

		this.add(bañostxt);
		this.add(baños);

		this.add(camastxt);
		this.add(camas);

		this.add(tipo_camas);
		this.add(box2);

		this.add(niños);
		this.add(box);

		this.add(extrasniños);

		this.add(preciominimo);

		Botones.nuevo.addActionListener(this);
		niños.addActionListener(this);
		flag = false;

		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				JOptionPane.showMessageDialog(null, "TIMER QUE SE ACTIVA CADA 15 SEGUNDOS", "TIMER",
						JOptionPane.INFORMATION_MESSAGE);
			}
		};
		Timer timer = new Timer(15000, taskPerformer);
		timer.setRepeats(true);
		timer.start();
		//este es mi componente de java swing que no hemos usado antes, me parece muy util para hacer algo rutinario que tenga que repetirse
		//cada x tiempo con un codigo muy sencillo

		huespedes.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				int aux = (Integer) huespedes.getValue();

				if (aux==1) {
					box2.removeItem("Doble");
				} 
				if (aux==2){
					box2.addItem("Doble");
				}
			}
		});
		
		//Algo que me ha parecido interesante es que si hay solo un huesped no estara la opcion de
		//cama doble, sin embargo si hay dos se añade y al subir mas la opcion ya se queda, si
		//volvemos a bajar a uno Doble desaparece
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Botones.nuevo) {
			niños.setSelected(false);
			//desactivar el check
		}

		if (e.getSource() == niños) {
			//usamos una bandera para saber cuando poner visible o invisible el extraniños
			//dependiendo de si hemos checkeado la casilla niños
			if (!flag) {
				extrasniños.setVisible(true);
				flag = true;
			} else {
				extrasniños.setVisible(false);
				flag = false;
			}
		}
	}
}
