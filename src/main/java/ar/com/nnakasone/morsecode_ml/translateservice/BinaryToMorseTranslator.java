package ar.com.nnakasone.morsecode_ml.translateservice;

import java.util.*;

import ar.com.nnakasone.morsecode_ml.entities.*;
import ar.com.nnakasone.morsecode_ml.patternservice.*;
import ar.com.nnakasone.morsecode_ml.patternservice.kmeans.KMeans;

/**
 * @author Nicolas Nakasone
 *
 */
public class BinaryToMorseTranslator implements TranslateService {

	private PatternAnalyzerService pas;
	
	private List<String> parsedMessage;
	
	/**
	 * Constructor
	 */
	public BinaryToMorseTranslator(List<String> parsedMessage) {
		pas = new KMeans(parsedMessage);
		this.parsedMessage = parsedMessage;
	}

	@Override
	public String translate() {
		List<String> translatedMessage = new ArrayList<String>();
		String result = "";
		boolean firstTime = true;
		
		while (pas.hasOtherOption()) {
			Iterator<String> it = this.parsedMessage.iterator();
			while(it.hasNext()) {
				String value = it.next();
				translatedMessage.add(pas.determineValue(value));
			}
			
			if (isValidMorseCode(translatedMessage)) {
				return convertToString(translatedMessage);
			} else {
				if (firstTime) {
					firstTime = false;
				} else {
					pas.undo();
				}
				translatedMessage.clear();
				pas.change();
			}
		}
		return result; 
	}

	private String convertToString(List<String> translatedMessage) {
		Iterator<String> it = translatedMessage.iterator();
		String response = "";
		while (it.hasNext()) {
			response = response.concat(it.next());
		}
		return response;
	}

	private boolean isValidMorseCode(List<String> translatedMessage) {
		Code morse = new Morse();
		boolean response = true;
		String aLetter = "";
		
		Iterator<String> it = translatedMessage.iterator();
		while (it.hasNext() && response) {
			String actual = it.next();
			if (actual.equals(" ")) {
				response = morse.exists(aLetter);		
				aLetter = "";
			} else {
				aLetter = aLetter.concat(actual);				
			}
		}
		
		return response;
	}

}
