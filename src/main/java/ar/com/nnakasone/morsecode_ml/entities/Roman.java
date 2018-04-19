package ar.com.nnakasone.morsecode_ml.entities;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Nicolas Nakasone
 *
 */
public class Roman extends Code {
	
	private static final String[] roman = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T",
			"U","V","W","X","Y","Z","0","1","2","3","4","5","6","7","8","9"," "};
	
	/**
	 * Constructur de Clase Roman
	 */
	public Roman() {
		code = new ArrayList<String>(Arrays.asList(roman));
	}

}