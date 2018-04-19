package ar.com.nnakasone.morsecode_ml;

import java.util.Iterator;
import java.util.List;

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
		List<String> result = tc.translate2Human();
		
		show(result);
		
		mr.setValue("HOLA MELI");
		tc.setMessage(mr);
		result = tc.translate2Morse();
		
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
