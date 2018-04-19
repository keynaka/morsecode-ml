package ar.com.nnakasone.morsecode_ml.parseservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ar.com.nnakasone.morsecode_ml.dto.MessageRequest;

/**
 * @author Nicolas Nakasone
 *
 */
public class RomanParser implements ParseService {

	private MessageRequest messageRequest;
	
	public RomanParser() {
	}

	/**
	 * Constructor de Clase RomanParser
	 * @param message
	 */
	public RomanParser(MessageRequest message) {
		this.messageRequest = message;
	}
	
	/**
	 * Separa cada codigo del mensaje en elementos separados
	 * @return parsedMessage
	 */
	public List<String> parse() {
		return new ArrayList<String>(Arrays.asList(messageRequest.getValue().split("")));
	}

}
