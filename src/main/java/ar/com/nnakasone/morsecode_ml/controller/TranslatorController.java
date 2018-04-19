package ar.com.nnakasone.morsecode_ml.controller;

import java.util.List;

import ar.com.nnakasone.morsecode_ml.dto.MessageRequest;
import ar.com.nnakasone.morsecode_ml.parseservice.*;
import ar.com.nnakasone.morsecode_ml.translateservice.*;

/**
 * @author Nicolas Nakasone
 *
 */
public class TranslatorController {

	private MessageRequest message;
	
	private TranslateService translator;
	
	private ParseService parser;
	
	/**
	 * Constructor de Clase TranslatorController
	 * @param message 
	 */
	public TranslatorController(MessageRequest message) {
		this.message = message;
	}

	/**
	 * Traduce un mensaje en binario a morse
	 * @return value
	 */
	public List<String> decodeBits2Morse() {
		//TODO: COMPLETAR
		return null;
	}
	
	/**
	 * Traduce un mensaje en morse a romano
	 * @return value
	 */
	public List<String> translate2Human() {
		parser = new MorseParser(this.message);
		List<String> result = parser.parse();
		
		translator = new MorseToRomanTranslator();
		result = translator.translate(result);
		
		return result;
	}
	
	/**
	 * Traduce un mensaje en romano a morse
	 * @return
	 */
	public List<String> translate2Morse() {
		return null;
	}
}
