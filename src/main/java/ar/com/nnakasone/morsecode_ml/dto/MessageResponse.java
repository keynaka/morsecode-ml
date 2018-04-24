/**
 * 
 */
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
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getResponse() {
		return response;
	}
	
	public void setResponse(String response) {
		this.response = response;
	}

}
