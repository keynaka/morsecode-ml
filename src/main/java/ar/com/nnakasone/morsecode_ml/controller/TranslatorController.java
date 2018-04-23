package ar.com.nnakasone.morsecode_ml.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import ar.com.nnakasone.morsecode_ml.dto.MessageRequest;
import ar.com.nnakasone.morsecode_ml.dto.MessageResponse;
import ar.com.nnakasone.morsecode_ml.services.ParseService;
import ar.com.nnakasone.morsecode_ml.services.TranslateService;
import ar.com.nnakasone.morsecode_ml.services.parser.*;
import ar.com.nnakasone.morsecode_ml.services.translator.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nicolas Nakasone
 *
 */

@RestController
public class TranslatorController {

	private TranslateService translator;
	
	private ParseService parser;
	
	/**
	 * Constructor vacio de Clase
	 */
	public TranslatorController() {}

	/**
	 * Traduce un mensaje en binario a morse
	 * @return value
	 */
	public MessageResponse decodeBits2Morse(MessageRequest messageRequest) {
		parser = new BinaryParser(messageRequest);
		List<String> result = parser.parse();
		
		translator = new BinaryToMorseTranslator(result);
		
		String translatedMessage = translator.translate();
		int code = (translatedMessage != "" ? HttpServletResponse.SC_OK : HttpServletResponse.SC_FORBIDDEN);
		
		MessageResponse response = new MessageResponse(code, translatedMessage);
		
		return response;
	}
	
	/**
	 * Traduce un mensaje en morse a romano
	 * @return value
	 */
	@RequestMapping(method = RequestMethod.POST, value="/2text", produces = "application/json")
	public MessageResponse translate2Human(@RequestBody MessageRequest messageRequest) {
		parser = new MorseParser(messageRequest);
		List<String> result = parser.parse();
		
		translator = new MorseToRomanTranslator(result);
		
		String translatedMessage = translator.translate();
		int code = (translatedMessage != "" ? HttpServletResponse.SC_OK : HttpServletResponse.SC_FORBIDDEN);
		
		MessageResponse response = new MessageResponse(code, translatedMessage);
		
		return response;
	}
	
	/**
	 * Traduce un mensaje en romano a morse
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value="/2morse", produces = "application/json")
	public MessageResponse translate2Morse(@RequestBody MessageRequest messageRequest) {
		parser = new RomanParser(messageRequest);
		List<String> result = parser.parse();
		
		translator = new RomanToMorseTranslator(result);

		String translatedMessage = translator.translate();
		int code = (translatedMessage != "" ? HttpServletResponse.SC_OK : HttpServletResponse.SC_FORBIDDEN);
		
		MessageResponse response = new MessageResponse(code, translatedMessage);
		
		return response;
	}
}
