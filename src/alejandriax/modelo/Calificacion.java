package alejandriax.modelo;

public class Calificacion {

	/**** VARIABLES ****/
	private String idArticulo;
	private String calificacion;
	private String comentario;

	/**** CONSTRUCTOR ****/
	public Calificacion(String idArticulo, String calificacion,
			String comentario) {
		this.idArticulo = idArticulo;
		this.calificacion = calificacion;
		this.comentario = comentario;
	}

	/**** GettersAndSetters ****/
	public String getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(String idArticulo) {
		this.idArticulo = idArticulo;
	}

	public String getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
}
