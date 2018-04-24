package ar.com.nnakasone.morsecode_ml.dto;

/**
 * @author Nicolas Nakasone
 *
 */
public class MessageRequest {

	private String text;
	
	/**
	 * Constructor de MessageRequest
	 * @param value
	 */
	public MessageRequest(String text) {
		this.text = text;
	}

	/**
	 * Constructor Vacio de MessageRequest
	 */
	public MessageRequest() {
	}

	/**
	 * Devuelve el mensaje cargado
	 * @return value
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * Seteo de mensaje a procesar
	 * @param value
	 */
	public void setValue(String value) {
		this.text = value;
	}
	
	/**
	 * Devuelve la longitud del mensaje a procesar
	 * @return longitud
	 */
	public int getLength() {
			return this.text.length();
	}
}
