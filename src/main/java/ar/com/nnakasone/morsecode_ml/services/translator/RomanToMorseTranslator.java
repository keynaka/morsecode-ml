package ar.com.nnakasone.morsecode_ml.services.translator;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import ar.com.nnakasone.morsecode_ml.exception.UnknownCodeException;

/**
 * @author Nicolas Nakasone
 *
 */
public class RomanToMorseTranslator extends RomanMorseTranslator {

	private final String OTHER_LETTER_SEPARATOR = " ";
	
	/**
	 * Constructor de RomanToMorseTranslator
	 */
	public RomanToMorseTranslator(List<String> parsedMessage) {
		super(parsedMessage);
	}
	
	/**
	 * Inicializa el map de relacion romano a morse
	 * @param map
	 */
	@Override
	protected void iniciateMap(Map<String, String> map) {
		for (int i=0 ; i<roman.getSize() ; i++) {
			map.put(roman.getCode(i), morse.getCode(i));
		}		
	}
	
	/**
	 * Traduce mensaje de romano a morse
	 * @param parsedMessage
	 */
	public String translate() throws UnknownCodeException{
		String translatedMessage = "";
		Iterator<String> it = this.parsedMessage.iterator();
		while(it.hasNext()) {
			String value = it.next().toUpperCase();
			if (roman.exists(value)) {
				translatedMessage = translatedMessage.concat(map.get(value));
				if (!value.equals(" "))
					translatedMessage = translatedMessage.concat(OTHER_LETTER_SEPARATOR);
			} else {
				throw new UnknownCodeException("El codigo ingresado no es traducible");
			}
		}
		return translatedMessage.substring(0, translatedMessage.length()-1);
	}
}
