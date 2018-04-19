package ar.com.nnakasone.morsecode_ml;

import java.util.Iterator;
import java.util.List;

import ar.com.nnakasone.morsecode_ml.controller.TranslatorController;
import ar.com.nnakasone.morsecode_ml.dto.MessageRequest;
import ar.com.nnakasone.morsecode_ml.parseservice.MorseParser;
import ar.com.nnakasone.morsecode_ml.parseservice.ParseService;
import ar.com.nnakasone.morsecode_ml.translateservice.MorseToRomanTranslator;
import ar.com.nnakasone.morsecode_ml.translateservice.RomanToMorseTranslator;
import ar.com.nnakasone.morsecode_ml.translateservice.TranslateService;

/**
 * @author Nicolas Nakasone
 *
 */
public class MainApplication {

	public static void main(String[] args) {
		//MessageRequest mr = new MessageRequest("HOLA MELI");
		//MessageRequest mr = new MessageRequest(".... --- .-.. .-  -- . .-.. ..");
/*		MessageRequest mr = new MessageRequest("-. --- .  - .  .- -- ---");
		
		ParseService mp = new MorseParser(mr);
		List<String> p = mp.parse();
		
		show(p);
		
		TranslateService ts = new MorseToRomanTranslator();
		p = ts.translate(p);
		
		show(p);
		
		ts = new RomanToMorseTranslator();
		p = ts.translate(p);
		
		show(p);*/
		
		MessageRequest mr = new MessageRequest(".... --- .-.. .-  -- . .-.. ..");
		TranslatorController tc = new TranslatorController(mr);
		List<String> result = tc.translate2Human();
		
		show(result);
	}
	
	
	/**
	 * TODO: BORRAR DESPUES, METODO DE TESTEO
	 */
	public static void show(List<String> p) {
		Iterator<String> i = p.iterator();
		int j = 0;
		while (i.hasNext()) {
			System.out.print(++j + ":\t");
			System.out.println(i.next());

		}
		System.out.println("-------------------------");
	}

}
