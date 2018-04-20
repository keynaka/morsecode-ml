package ar.com.nnakasone.morsecode_ml.parseservice;

import java.util.*;

import ar.com.nnakasone.morsecode_ml.dto.MessageRequest;

/**
 * @author Nicolas Nakasone
 *
 */
public class BinaryParser implements ParseService {

	private MessageRequest messageRequest;

	/**
	 * Constructor
	 * @param message
	 */
	public BinaryParser(MessageRequest message) {
		this.messageRequest = message;
	}
	
	public List<String> parse() {

		cleanMessage(); 
		return separateElements();
	}

	private List<String> separateElements() {
		List<String> parsedMessage = new ArrayList<String>();
		String msg = messageRequest.getValue();
		
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

	private void cleanMessage() {
		this.messageRequest.setValue(this.messageRequest.getValue().replace("0", " ").trim().replace(" ", "0"));
	}
}
