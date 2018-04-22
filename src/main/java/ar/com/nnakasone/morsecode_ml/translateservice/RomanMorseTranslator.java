package ar.com.nnakasone.morsecode_ml.translateservice;

import java.util.HashMap;
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
	
	protected List<String> parsedMessage;

	/**
	 * Constructor de Clase RomanMorseTranslator
	 */
	public RomanMorseTranslator(List<String> parsedMessage) {
		roman = new Roman();
		morse = new Morse();
		map = new HashMap<String,String>();
		this.iniciateMap(map);
		this.parsedMessage = parsedMessage;
	}
	
	public abstract String translate();
	
	public abstract void iniciateMap(Map<String,String> map);
}
