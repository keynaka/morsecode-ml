/**
 * 
 */
package ar.com.nnakasone.morsecode_ml.entities;

/**
 * @author Nicolas Nakasone
 *
 */
public interface Code {

	public String getCode(int i);
	public int getSize();
	public boolean exists(String value);
}
