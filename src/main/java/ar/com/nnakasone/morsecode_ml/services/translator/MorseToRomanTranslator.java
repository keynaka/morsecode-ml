package ar.com.nnakasone.morsecode_ml.services.translator;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author Nicolas Nakasone
 *
 */

public class MorseToRomanTranslator extends RomanMorseTranslator{
	
	private final String EMPTY_ANSWER = "";

	/**
	 * Constructor
	 */
	public MorseToRomanTranslator(List<String> parsedMessage) {
		super(parsedMessage);
	}
	
	/**
	 * Inicializa el map de relacion morse a romano
	 * @param map
	 */
	@Override
	public void iniciateMap(Map<String, String> map) {
		for (int i=0 ; i<roman.getSize() ; i++) {
			map.put(morse.getCode(i), roman.getCode(i));
		}
	}		
	
	/**
	 * Traduce mensaje de morse a romano
	 * @param parsedMessage
	 */
	public String translate() {
		String translatedMessage = "";
		Iterator<String> it = this.parsedMessage.iterator();
		while(it.hasNext()) {
			String value = it.next();
			if (morse.exists(value)) {
				translatedMessage = translatedMessage.concat(map.get(value));				
			} else {
				return EMPTY_ANSWER;
			}
		}
		return translatedMessage;
	}
}
