package ar.com.nnakasone.morsecode_ml.dto;

/**
 * @author Nicolas Nakasone
 *
 */
public class MessageRequest {

	private String value;
	
	/**
	 * Constructor de MessageRequest
	 * @param value
	 */
	public MessageRequest(String value) {
		this.value = value;
	}

	/**
	 * Constructor Vacio de Clase
	 */
	public MessageRequest() {
	}

	/**
	 * Devuelve el mensaje cargado
	 * @return value
	 */
	public String getValue() {
		return value;
	}
	
	/**
	 * Seteo de mensaje a procesar
	 * @param value
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	/**
	 * Devuelve la longitud del mensaje a procesar
	 * @return longitud
	 */
	public int getLength() {
			return this.value.length();
	}

	
}
