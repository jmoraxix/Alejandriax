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

/**
 * @author jmora 31/7/141
 *
 */
import java.awt.Dialog;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class VentanaEmergente extends JDialog {
	
	private JPanel panel;

	public VentanaEmergente(JFrame frame, String title, String fondo) {
		super(frame, title, true);
		setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(frame);
		setSize(650, 480);

		panel = new PanelConFondo(fondo);
		setContentPane(panel);
	}
	
	public VentanaEmergente(JFrame frame, String title, String fondo, int ancho, int alto) {
		super(frame, title, true);
		setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(frame);
		setSize(ancho, alto);

		panel = new PanelConFondo(fondo);
		setContentPane(panel);
	}
}
