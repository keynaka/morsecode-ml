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

}
