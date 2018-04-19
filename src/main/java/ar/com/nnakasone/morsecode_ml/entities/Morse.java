package ar.com.nnakasone.morsecode_ml.entities;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Nicolas Nakasone
 *
 */
public class Morse extends Code {

	private static final String[] morseCode = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--",
			"-.","---",".--","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..",
			"-----",".----","..---","...--","....-",".....","-....","--...","---..","----."," "};
	
	/**
	 * Constructor de Clase Morse
	 */
	public Morse() {
		code = new ArrayList<String>(Arrays.asList(morseCode));
	}

}
