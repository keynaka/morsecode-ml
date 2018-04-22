package ar.com.nnakasone.morsecode_ml.entities;

/**
 * @author Nicolas Nakasone
 *
 */
public class Binary implements Code {
	
	public final static String DOT = "DOT";
	
	public final static String DASH = "DASH";
	
	public final static String INNER_SPACE = "INNER_SPACE";
	
	public final static String OUTER_SPACE = "OUTER_SPACE";
	
	private final String[] posibleCodes = {DOT, DASH, INNER_SPACE, OUTER_SPACE};
	
	public Binary() {
	}

	@Override
	public String getCode(int i) {
		return posibleCodes[i];
	}

	@Override
	public int getSize() {
		return posibleCodes.length;
	}

	@Override
	public boolean exists(String value) {
		int i = 0;
		boolean found = false;
		while (i<posibleCodes.length && !found) {
			found = (posibleCodes[i].equals(value));
			i++;
		}
		return found;
	}
}
