package ar.com.nnakasone.morsecode_ml;

import java.util.Iterator;
import java.util.List;

import ar.com.nnakasone.morsecode_ml.controller.TranslatorController;
import ar.com.nnakasone.morsecode_ml.dto.MessageRequest;
import ar.com.nnakasone.morsecode_ml.parseservice.BinaryParser;
import ar.com.nnakasone.morsecode_ml.patternservice.kmeans.KMeans;

/**
 * @author Nicolas Nakasone
 *
 */
public class MainApplication {

	public static void main(String[] args) {
/*		MessageRequest mr = new MessageRequest(".... --- .-.. .-  -- . .-.. ..");
		TranslatorController tc = new TranslatorController(mr);
		List<String> result = tc.translate2Human();
		
		show(result);
		
		mr.setValue("HOLA MELI");
		tc.setMessage(mr);
		result = tc.translate2Morse();
		
		show(result);*/
		
		MessageRequest mr = new MessageRequest("000000001000000001111011100000000011100000");
		BinaryParser bp = new BinaryParser(mr);
		List<String> parsedMessage = bp.parse();
		
		show(parsedMessage);
		
		KMeans km = new KMeans(parsedMessage);
		
		System.out.println(km.getDotCluster());
		System.out.println(km.getDashCluster());
		System.out.println(km.getInnerSpaceCluster());
		System.out.println(km.getOuterSpaceCluster());
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
