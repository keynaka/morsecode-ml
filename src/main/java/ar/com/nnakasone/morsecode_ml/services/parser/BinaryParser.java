package ar.com.nnakasone.morsecode_ml.services.parser;

import java.util.*;

import ar.com.nnakasone.morsecode_ml.dto.MessageRequest;
import ar.com.nnakasone.morsecode_ml.services.ParseService;

/**
 * @author Nicolas Nakasone
 *
 */
public class BinaryParser implements ParseService {

	private MessageRequest messageRequest;

	/**
	 * Constructor de BinaryParser
	 * @param message
	 */
	public BinaryParser(MessageRequest message) {
		this.messageRequest = message;
	}
	
	/**
	 * Elimina los ruidos del inicio y fin del mensaje y
	 * devuelve el mensaje separado por letra dentro de una lista.
	 * @return parsedMessage
	 */
	@Override
	public List<String> parse() {
		cleanMessage(); 
		return separateElements();
	}

	/**
	 * Elimina los ruidos del inicio y fin del mensaje
	 */
	private void cleanMessage() {
		this.messageRequest.setValue(this.messageRequest.getText().replace("0", " ").trim().replace(" ", "0"));
	}
	
	/**
	 * Devuelve el mensaje separado por letra dentro de una lista.
	 * @return parsedMessage
	 */
	private List<String> separateElements() {
		List<String> parsedMessage = new ArrayList<String>();
		String msg = messageRequest.getText();
		
		int i = 0;
		char actualValue = msg.charAt(i);
		
		while (!msg.isEmpty() && i < msg.length()) {
			if (msg.charAt(i) != actualValue) {
				parsedMessage.add(msg.substring(0, i));
				actualValue = msg.charAt(i);
				msg = msg.substring(i);
				i = 0;
			}
			i++;
		}
		parsedMessage.add(msg);
		
		return parsedMessage;
	}	

	public MessageRequest getMessageRequest() {
		return messageRequest;
	}

	public void setMessageRequest(MessageRequest messageRequest) {
		this.messageRequest = messageRequest;
	}
}
