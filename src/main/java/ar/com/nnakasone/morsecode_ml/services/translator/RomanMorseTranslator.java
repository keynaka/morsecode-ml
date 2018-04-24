package ar.com.nnakasone.morsecode_ml.services.translator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ar.com.nnakasone.morsecode_ml.entities.*;
import ar.com.nnakasone.morsecode_ml.entities.Morse;
import ar.com.nnakasone.morsecode_ml.entities.Roman;
import ar.com.nnakasone.morsecode_ml.exception.UnknownCodeException;
import ar.com.nnakasone.morsecode_ml.services.TranslateService;

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
	 * Constructor de RomanMorseTranslator
	 */
	public RomanMorseTranslator(List<String> parsedMessage) {
		roman = new Roman();
		morse = new Morse();
		map = new HashMap<String,String>();
		this.iniciateMap(map);
		this.parsedMessage = parsedMessage;
	}
	
	public abstract String translate() throws UnknownCodeException;
	
	public abstract void iniciateMap(Map<String,String> map);
}
