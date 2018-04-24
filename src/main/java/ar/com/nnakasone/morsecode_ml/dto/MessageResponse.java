package ar.com.nnakasone.morsecode_ml.dto;

/**
 * @author Nicolas Nakasone
 *
 */
public class MessageResponse {

	private int code;

	private String response;
	
	/**
	 * Constructor de MessageResponse
	 */
	public MessageResponse(int code, String response) {
		this.code = code;
		this.response = response;
	}
	
	/**
	 * Devuelve el codigo de respuesta del http servlet
	 * @return code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * Setea el codigo de respuesta del http servlet
	 * @param code
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * Devuelve el valor de la respuesta
	 * @return response
	 */
	public String getResponse() {
		return response;
	}
	
	/**
	 * Setea el valor de la respuesta
	 * @param response
	 */
	public void setResponse(String response) {
		this.response = response;
	}
}
