package ar.com.nnakasone.morsecode_ml;

import ar.com.nnakasone.morsecode_ml.controller.TranslatorController;
import ar.com.nnakasone.morsecode_ml.dto.MessageRequest;

/**
 * @author Nicolas Nakasone
 *
 */
public class MainApplication {

	public static void main(String[] args) {
		MessageRequest mr = new MessageRequest(".... --- .-.. .-  -- . .-.. ..");
		TranslatorController tc = new TranslatorController(mr);
		String result = tc.translate2Human();
		
		System.out.println(result);
		
		mr.setValue("HOLA MELI");
		tc.setMessage(mr);
		result = tc.translate2Morse();
		
		System.out.println(result);
		
		mr = new MessageRequest("0000000011011100111111000111110000110000011100000011100000");
		tc.setMessage(mr);
		result = tc.decodeBits2Morse();
		
		System.out.println(result);
	}
}
