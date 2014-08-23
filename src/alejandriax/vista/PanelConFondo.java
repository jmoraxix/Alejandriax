/**
 * Primer Proyecto POO
 * Jose David Mora Loria
 * 2014004856
 * Diego Delgado Cerdas
 * 2013099268
 * David Diaz
 * 2014004725
 * Roger Villalobos
 * 2014079369
 * 31/07/2014
 */

package alejandriax.vista;

import java.awt.BorderLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import alejandriax.Alejandriax;

/**
 * @author jmora 31/7/2014
 * Define un panel extiendo a JPanel y le asigna un fondo
 * 
 */
@SuppressWarnings("serial")
public class PanelConFondo extends JPanel {
	
	private JButton btn;

	//Recibe un string con la URL de la imagen
	public PanelConFondo(String urlImagen) {
		setForeground(SystemColor.controlHighlight);

		try {
			URL imagen = Alejandriax.class.getResource(urlImagen);
			BufferedImage img = ImageIO.read(imagen);
			BgBorder borde = new BgBorder( img );
			setBorder(borde);
		} catch (IOException e) {
			e.printStackTrace();
		}

		setLayout(null);
	}

	//Recibe un string con la URL de la imagen y si el panel es opaco o no
	public PanelConFondo(String urlImagen, boolean isOpaque) {
		setForeground(SystemColor.controlHighlight);

		try {
			URL imagen = Alejandriax.class.getResource(urlImagen);
			BufferedImage img = ImageIO.read(imagen);
			BgBorder borde = new BgBorder( img );
			setBorder(borde);
		} catch (IOException e) {
			e.printStackTrace();
		}

		setOpaque(isOpaque);
		setLayout(new BorderLayout(0, 0));

		btn = new JButton("");
		btn.setOpaque(false);
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false);
		add(btn);
	}

	public JButton getBtn() {
		return btn;
	}

}
