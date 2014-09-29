package alejandriax.vista.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import alejandriax.control.Coordinador;
import alejandriax.control.Ordenar;
import alejandriax.control.Principal;
import alejandriax.modelo.Articulo;
import alejandriax.modelo.Colega;
import alejandriax.modelo.Estudiante;
import alejandriax.modelo.Familiar;
import alejandriax.modelo.Libro;
import alejandriax.vista.PanelMostrarLibros;
import alejandriax.vista.VentanaConsulta;

import javax.swing.JCheckBox;

@SuppressWarnings("serial")
public class ConsultaPrestamo extends VentanaConsulta {

	private Coordinador coordinador;
	private PanelMostrarLibros panel;
	private JCheckBox chPrestado, chSinPrestar;

	public ConsultaPrestamo(JFrame frame) {
		super(frame, "Consulta libros");
		getLblConsulta().setText("Consulta libros");
		
		getCmbOpciones().setModel(new DefaultComboBoxModel(new String[] {"-----Seleccione-----",
				"C\u00f3digo",
				"Fecha",
				"Estado",
				"Persona",
				"T\u00edtulo del art\u00edculo",
		"Dimitir"}));
	
		chPrestado = new JCheckBox("Prestado");
		chPrestado.setSelected(true);
		chPrestado.setBounds(661, 91, 129, 23);
		getContentPane().add(chPrestado);
		
		chSinPrestar = new JCheckBox("Sin prestar");
		chSinPrestar.setSelected(true);
		chSinPrestar.setBounds(794, 91, 143, 23);
		getContentPane().add(chSinPrestar);

		getBtnBuscar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(cmbOpciones.getSelectedIndex() != 0){
					ArrayList<Libro> libros = new ArrayList<Libro>();
					if(chSinPrestar.isSelected())
						libros.addAll(Principal.getLibrosDisponibles());
					if(chPrestado.isSelected())
						libros.addAll(Principal.getLibrosPrestados());
					ArrayList<Libro> res = (ArrayList<Libro>) libros.clone();
					synchronized (coordinador.getConsultaLibro()) {
						switch (cmbOpciones.getSelectedIndex()) {
						case 1:
							if (!getTxtParametro().getText().equals(""))
								for (Libro libro : libros)
									if (!libro.getIdArticulo().equalsIgnoreCase(txtParametro.getText()))
										res.remove(libro);
							Ordenar.ordenarLibroCodigo(res);
							llenarPanel(res);
							break;
						case 2:
							if (!getTxtParametro().getText().equals("")) 
								for (Libro libro : libros)
									if(!libro.getTituloArticulo().equalsIgnoreCase(txtParametro.getText()))
										res.remove(libro);
							llenarPanel(res);
							break;
						case 3:
							if (!getTxtParametro().getText().equals(""))
								for (Libro libro : libros)
									if (!libro.getAutor().equalsIgnoreCase(txtParametro.getText()))
										res.remove(libro);
							Ordenar.ordenarLibroAutor(res);
							llenarPanel(res);
							break;
						case 4:
							if (!getTxtParametro().getText().equals("")) {
								for (Libro libro : libros)
									if (!libro.getEditorial().equalsIgnoreCase(txtParametro.getText()))
										res.remove(libro);
							}
							Ordenar.ordenarLibroEditorial(res);
							llenarPanel(res);
							break;
						case 5:
							if (!getTxtParametro().getText().equals("")) {
								for (Libro libro : libros)
									if (!libro.getEdicion().equalsIgnoreCase(txtParametro.getText()))
										res.remove(libro);
							}
							Ordenar.ordenarLibroEdicion(res);
							llenarPanel(res);
							break;
						case 6:
							if (!getTxtParametro().getText().equals("")) {
								for (Libro libro : libros)
									if (!libro.getIdioma().equalsIgnoreCase(txtParametro.getText()))
										res.remove(libro);
							}
							Ordenar.ordenarLibroIdioma(res);
							llenarPanel(res);
							break;
						case 7:
							if (!getTxtParametro().getText().equals("")) {
								for (Libro libro : libros)
									if (!libro.getGenero().equalsIgnoreCase(txtParametro.getText()))
										res.remove(libro);
							}
							Ordenar.ordenarLibroGenero(res);
							llenarPanel(res);
							break;
						default:
							JOptionPane
							.showMessageDialog(
									coordinador.getConsultaLibro(),
									"Por favor, seleccione una opci\u00f3n de b\u00fasqueda v\u00e1lida.",
									"Error", JOptionPane.ERROR_MESSAGE);
							break;
						}
					}  
				} else
					JOptionPane.showMessageDialog(coordinador.getConsultaLibro(), 
							"Por favor, seleccione una opci\u00f3n de b\u00fasqueda v\u00e1lida.", 
							"Error", JOptionPane.ERROR_MESSAGE);
			}
		});

		llenarPanel(Principal.getLibros());

	}

	public void llenarPanel(ArrayList<Libro> libros){
		panel = new PanelMostrarLibros(coordinador.getVentanaPrincipal());
		getScrollPanelConsulta().setViewportView(panel);

		for(Libro libro : libros){
			panel.agregarLibro(libro);
		}
	}

	public Coordinador getCoordinador() {
		return coordinador;
	}

	public void setCoordinador(Coordinador coordinador) {
		this.coordinador = coordinador;
	}
}
