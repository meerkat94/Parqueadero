package dominio.excepcion;

public class ServicioParqueoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ServicioParqueoException(String message) {
		super(message);
	}
}
