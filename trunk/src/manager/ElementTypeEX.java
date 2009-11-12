package manager;

// TODO: Auto-generated Javadoc
/**
 * La classe rappresenta le eccezioni dovute ad operazioni su tipi di file
 * multimediali errati.
 */
public class ElementTypeEX extends Exception {

	/**
	 * Instantiates a new element type ex.
	 */
	public ElementTypeEX() {
		super();
	}

	/**
	 * Instantiates a new element type ex.
	 * 
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 */
	public ElementTypeEX(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new element type ex.
	 * 
	 * @param message
	 *            the message
	 */
	public ElementTypeEX(String message) {
		super(message);
	}

	/**
	 * Instantiates a new element type ex.
	 * 
	 * @param cause
	 *            the cause
	 */
	public ElementTypeEX(Throwable cause) {
		super(cause);
	}

}
