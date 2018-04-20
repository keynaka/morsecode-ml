package ar.com.nnakasone.morsecode_ml.translateservice;

import java.util.Iterator;
import java.util.List;

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
		String translatedMessage = "";
		Iterator<String> it = this.parsedMessage.iterator();
		while(it.hasNext()) {
			String value = it.next();
			translatedMessage = translatedMessage.concat(pas.determineValue(value));
		}
		return translatedMessage;
	}

}
