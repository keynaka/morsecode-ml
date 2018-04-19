package ar.com.nnakasone.morsecode_ml.translateservice;

import java.util.Map;

/**
 * @author Nicolas Nakasone
 *
 */
public class RomanToMorseTranslator extends RomanMorseTranslator {

	/**
	 * Constructor vacio del servicio
	 */
	public RomanToMorseTranslator() {
		super();
	}
	
	/**
	 * Inicializa el map de relacion romano a morse
	 * @param map
	 */
	@Override
	public void iniciateMap(Map<String, String> map) {
		for (int i=0 ; i<roman.getSize() ; i++) {
			map.put(roman.getCode(i), morse.getCode(i));
		}		
	}

}
