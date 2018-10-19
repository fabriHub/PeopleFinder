package it.persistenza.interfaccia;

public class IDAOException extends Exception{
	private static final long serialVersionUID = 6700212922466694442L;

	public IDAOException() {
		super();
	}

	public IDAOException(String message, Throwable cause) {
		super(message, cause);
	}

	public IDAOException(String message) {
		super(message);
	}

	public IDAOException(Throwable cause) {
		super(cause);
	}
}
