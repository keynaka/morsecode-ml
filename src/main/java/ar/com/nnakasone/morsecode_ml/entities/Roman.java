package ar.com.nnakasone.morsecode_ml.entities;

/**
 * @author Nicolas Nakasone
 *
 */
public class Roman implements Code {
	
	private final String[] roman = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T",
			"U","V","W","X","Y","Z","0","1","2","3","4","5","6","7","8","9"," "};
	
	/**
	 * Constructur de Clase Roman
	 */
	public Roman() {
	}
	
	public String getCode(int i) {
		return this.roman[i];
	}

	public int getSize() {
		return this.roman.length;
	}
	
	/**
	 * Devuelve si existe el valor ingresado dentro de los posibles en el codigo Romano.
	 * @return found
	 */
	@Override
	public boolean exists(String value) {
		int i = 0;
		boolean found = false;
		while (i<roman.length && !found) {
			found = (roman[i].equals(value));
			i++;
		}
		return found;
	}
}
