package ar.com.nnakasone.morsecode_ml.entities;

import java.util.List;

/**
 * @author Nicolas Nakasone
 *
 */
public abstract class Code {

	protected List<String> code;

	/**
	 * Devuelve el String de la posicion que indiques
	 * @param index
	 * @return value
	 */
	public String getCode(int i) {
		return this.code.get(i);
	}
	
	/**
	 * Devuelve la cantidad de codigos disponibles
	 * @return tamaño
	 */
	public int getSize() {
		return this.code.size();
	}
}
