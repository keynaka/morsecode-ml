/**
 * 
 */
package ar.com.nnakasone.morsecode_ml.exception;

/**
 * @author Nicolas Nakasone
 *
 */
public class UnknownCodeException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de UnknownCodeException
	 * @param message
	 */
	public UnknownCodeException(String message) {
		super(message);
	}
}