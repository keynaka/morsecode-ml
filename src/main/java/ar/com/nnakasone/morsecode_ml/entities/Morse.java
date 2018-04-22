package ar.com.nnakasone.morsecode_ml.entities;

/**
 * @author Nicolas Nakasone
 *
 */
public class Morse implements Code {

	private final String[] morseCode = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--",
			"-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..",
			"-----",".----","..---","...--","....-",".....","-....","--...","---..","----."," "};

	public String getCode(int i) {
		return morseCode[i];
	}

	public int getSize() {
		return morseCode.length;
	}

}
