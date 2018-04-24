package ar.com.nnakasone.morsecode_ml.entities;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Nicolas Nakasone
 *
 */
public class Morse implements Code {
	
	public final static String DOT = "DOT";
	
	public final static String DASH = "DASH";
	
	public final static String INNER_SPACE = "INNER_SPACE";
	
	public final static String OUTER_SPACE = "OUTER_SPACE";

	private final String[] morseCode = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--",
			"-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..",
			"-----",".----","..---","...--","....-",".....","-....","--...","---..","----."," "};
	
	private Map<String,String> morseNameValueRelation;
	
	
	/**
	 * Constructor de Morse
	 */
	public Morse() {
		morseNameValueRelation = new HashMap<String,String>();
		morseNameValueRelation.put(Morse.DOT, ".");
		morseNameValueRelation.put(Morse.DASH, "-");
		morseNameValueRelation.put(Morse.INNER_SPACE, "");
		morseNameValueRelation.put(Morse.OUTER_SPACE, " ");			
	}
	
	public String getCode(int i) {
		return morseCode[i];
	}

	public int getSize() {
		return morseCode.length;
	}

	/**
	 * Devuelve si existe el valor dentro de la tabla de codigo Morse.
	 * @return found
	 */
	@Override
	public boolean exists(String value) {
		int i = 0;
		boolean found = false;
		while (i<morseCode.length && !found) {
			found = (morseCode[i].equals(value));
			i++;
		}
		return found;
	}

	/**
	 * Devuelve el valor que se encontraba con el nombre del caracter morse a su valor real
	 * @param value
	 * @return
	 */
	public String getMorse(String value) {
		return this.morseNameValueRelation.get(value);
	}
}
