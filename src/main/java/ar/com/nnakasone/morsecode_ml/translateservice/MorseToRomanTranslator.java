package ar.com.nnakasone.morsecode_ml.translateservice;

import java.util.List;
import java.util.Map;


/**
 * @author Nicolas Nakasone
 *
 */
public class MorseToRomanTranslator extends RomanMorseTranslator{
	
	/**
	 * Constructor vacio del servicio
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

}
