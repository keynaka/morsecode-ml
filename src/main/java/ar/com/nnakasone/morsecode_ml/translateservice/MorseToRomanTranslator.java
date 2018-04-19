package ar.com.nnakasone.morsecode_ml.translateservice;

import java.util.Map;


/**
 * @author Nicolas Nakasone
 *
 */
public class MorseToRomanTranslator extends RomanMorseTranslator{
	
	/**
	 * Constructor vacio del servicio
	 */
	public MorseToRomanTranslator() {
		super();
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

}
