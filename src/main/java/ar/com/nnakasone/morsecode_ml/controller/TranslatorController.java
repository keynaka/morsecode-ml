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
	 * Constructor vacio de Clase
	 */
	public TranslatorController() {
		
	}
	
	/**
	 * Constructor de Clase TranslatorController
	 * @param message 
	 */
	public TranslatorController(MessageRequest message) {
		this.message = message;
	}
	
	public void setMessage(MessageRequest mr) {
		this.message = mr;
	}

	/**
	 * Traduce un mensaje en binario a morse
	 * @return value
	 */
	public String decodeBits2Morse() {
		parser = new BinaryParser(this.message);
		List<String> result = parser.parse();
		
		translator = new BinaryToMorseTranslator(result);
		
		return translator.translate();
	}
	
	/**
	 * Traduce un mensaje en morse a romano
	 * @return value
	 */
	public String translate2Human() {
		parser = new MorseParser(this.message);
		List<String> result = parser.parse();
		
		translator = new MorseToRomanTranslator(result);
		
		return translator.translate();
	}
	
	/**
	 * Traduce un mensaje en romano a morse
	 * @return
	 */
	public String translate2Morse() {
		parser = new RomanParser(this.message);
		List<String> result = parser.parse();
		
		translator = new RomanToMorseTranslator(result);

		return translator.translate();
	}
}
