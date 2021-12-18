/**
	Ventana.java
	17 nov 2021 10:18:48
	@author Miguel Reid Ruiz
 */
package programa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * @author mikey
 *
 */
public class Ventana extends JFrame implements ActionListener{

	ImageIcon img;
	JMenuBar mb;
	JMenu archivo, registro, ayuda;
	JMenuItem salir, altapisos, bajapisos, acerca;
	Dialogo dialogo;
	Ventanabotones botones;
	Ventananorte norte;
	JLabel titulo;

	/**
	 * Instantiates a new ventana.
	 */
	public Ventana() {
		super("Gestion Apartamentos Turisticos DulceSol");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.getContentPane().setBackground(Color.decode("#d6e2e9"));

		this.setLayout(new BorderLayout());
		this.setBounds(100, 50, 700, 600);
		img = new ImageIcon(getClass().getResource("/recursos/icono.png"));
		this.setIconImage(img.getImage());
		
		norte = new Ventananorte();
				
        mb = new JMenuBar();

        archivo = new JMenu("Archivo");
        salir = new JMenuItem("Salir");
        salir.addActionListener(this);
        archivo.add(salir);
        mb.add(archivo);
        //tendremos un JMenuBar con las opciones diferentes
        
        registro = new JMenu("Registro");
        altapisos = new JMenuItem("Altapisos");
        bajapisos = new JMenuItem("Bajapisos");
        altapisos.addActionListener(this);
        bajapisos.addActionListener(this);
        registro.add(altapisos);
        registro.add(bajapisos);
        mb.add(registro);
        
		registro.addActionListener(this);
		registro.setMnemonic(KeyEvent.VK_R);
		bajapisos.setMnemonic(KeyEvent.VK_B);
		altapisos.setMnemonic(KeyEvent.VK_A);
		//nemotecnicos R para abrir el menu y B o A para alta o bajapisos

        ayuda = new JMenu("Ayuda");
        acerca = new JMenuItem("Acerca de");
        acerca.addActionListener(this);
        ayuda.add(acerca);
        mb.add(ayuda);
        //en el ayuda estara en salir donde haremos exit con runtime
        
        titulo = new JLabel("Apartamentos DulceSol");
		titulo.setFont(new Font("Serif", Font.PLAIN, 40));
		this.add(titulo, BorderLayout.CENTER);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width/2, screenSize.height/2);
        //pondremos el tamaño a la mitad de la altura y el ancho
        
        botones = new Ventanabotones();
		botones.uno.addActionListener(this);
		botones.dos.addActionListener(this);
        
        this.setJMenuBar(mb);
        //ponemos el menu a lo creado anteriormente
        this.add(botones, BorderLayout.SOUTH);
        this.add(norte, BorderLayout.WEST);
        this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource()==salir) {
			Runtime.getRuntime().exit(0);
		}
		if(e.getSource()==bajapisos) {
			JOptionPane.showMessageDialog(null, "La opcion no esta desarrollada", "AVISO", JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getSource()==altapisos) {
			dialogo = new Dialogo();        
	        this.setVisible(false);
	        this.setDefaultCloseOperation(Ventana.EXIT_ON_CLOSE);
	        this.dispose();
	        //abrimos la ventana dialogo
		}
		if(e.getSource()==botones.dos) {
			JOptionPane.showMessageDialog(null, "La opcion no esta desarrollada", "AVISO", JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getSource()==botones.uno) {
			dialogo = new Dialogo();        
	        this.setVisible(false);
	        this.setDefaultCloseOperation(Ventana.EXIT_ON_CLOSE);
	        this.dispose();
	        //abrimos la ventana dialogo
		}
		if(e.getSource()==acerca) {
	        String strAyuda = "2021-2022 DulceSol Apartment Group \n Avenida Valverde, 28 \n 04001 Almeria, España";
			JOptionPane.showMessageDialog(null, strAyuda, "INFORMACION LEGAL", JOptionPane.INFORMATION_MESSAGE);
			//pondremos informacion basica como el nombre, codigo postal...
		}
		
	}
}
