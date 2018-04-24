package ar.com.nnakasone.morsecode_ml.services.translator;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import ar.com.nnakasone.morsecode_ml.exception.UnknownCodeException;

/**
 * @author Nicolas Nakasone
 *
 */

public class MorseToRomanTranslator extends RomanMorseTranslator {
	
	/**
	 * Constructor de MorseToRomanTranslator
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
	 * En caso de encontrar un codigo no existente en la tabla, lanzara una excepcion
	 * @param parsedMessage
	 */
	public String translate() throws UnknownCodeException {
		String translatedMessage = "";
		Iterator<String> it = this.parsedMessage.iterator();
		while(it.hasNext()) {
			String value = it.next();
			if (morse.exists(value)) {
				translatedMessage = translatedMessage.concat(map.get(value));				
			} else {
				throw new UnknownCodeException("El codigo ingresado no es traducible");
			}
		}
		return translatedMessage;
	}
}
