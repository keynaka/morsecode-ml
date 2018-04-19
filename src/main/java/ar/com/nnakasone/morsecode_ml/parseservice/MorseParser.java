package ar.com.nnakasone.morsecode_ml.parseservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import ar.com.nnakasone.morsecode_ml.dto.MessageRequest;

/**
 * @author Nicolas Nakasone
 *
 */
public class MorseParser implements ParseService {

	private MessageRequest messageRequest;
	
	/**
	 * Constructor
	 * @param message
	 */
	public MorseParser(MessageRequest message) {
		this.messageRequest = message;
	}

	/**
	 * Separa cada codigo del mensaje en elementos separados
	 * @return parsedMessage
	 */
	public List<String> parse() {
		List<String> parsedMessage = new ArrayList<String>(Arrays.asList(messageRequest.getValue().split("\\s")));
		
		//TODO: mejorar problema de los espacios
		for (int i=0 ; i<parsedMessage.size() ; i++) {
			if (parsedMessage.get(i).isEmpty()) parsedMessage.set(i," ");
		}
		
		return parsedMessage;
	}

}
