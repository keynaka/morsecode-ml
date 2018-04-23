package ar.com.nnakasone.morsecode_ml.services.patternanalyzer;

/**
 * @author Nicolas Nakasone
 *
 */
public class Element {

	private Float position; 
	
	private String type;
	
	private String value;

	/**
	 * Constructor de Clase
	 */
	public Element(String value) {
		this.setPosition(value);
		this.setType(value);
		this.setValue(value);
		
	}
	
	public Float getPosition() {
		return position;
	}
	
	public void setPosition(String value) {
		this.position = (float) value.length();
	}
	
	public String getType() {
		return type;
	}

	public void setType(String value) {
		this.type = Character.toString(value.charAt(0));
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Devuelve la distancia entre un elemento y otro
	 * @param e
	 * @return
	 */
	public float distance(Element e) {
		return Math.abs(this.position - e.getPosition());
	}
	
	/**
	 * Devuelve la distancia de este elemento a un cierto valor
	 * @param value
	 * @return
	 */
	public float distance(int value) {
		return Math.abs(this.position - value);
	}

	public void setPosition(float i) {
		this.position = i;
	}
	
	public int hashCode() {
		return 11 * this.value.hashCode() + 13 * this.value.hashCode();
	}
}
