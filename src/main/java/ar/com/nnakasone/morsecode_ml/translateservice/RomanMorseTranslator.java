package ar.com.nnakasone.morsecode_ml.translateservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import ar.com.nnakasone.morsecode_ml.entities.*;
import ar.com.nnakasone.morsecode_ml.entities.Morse;
import ar.com.nnakasone.morsecode_ml.entities.Roman;

/**
 * @author Nicolas Nakasone
 *
 */
public abstract class RomanMorseTranslator implements TranslateService {
	
	protected Map<String,String> map;
	
	protected Code roman;
	
	protected Code morse;

	/**
	 * Constructor de Clase RomanMorseTranslator
	 */
	public RomanMorseTranslator() {
		roman = new Roman();
		morse = new Morse();
		map = new HashMap<String,String>();
		this.iniciateMap(map);
	}
	
	/**
	 * Traduce mensaje de un codigo a otro
	 * @param parsedMessage
	 */
	public List<String> translate(List<String> parsedMessage) {
		List<String> translatedMessage = new ArrayList<String>();
		Iterator<String> it = parsedMessage.iterator();
		while(it.hasNext()) {
			translatedMessage.add(map.get(it.next()));
		}
		return translatedMessage;
	}
	
	public abstract void iniciateMap(Map<String,String> map);

}
