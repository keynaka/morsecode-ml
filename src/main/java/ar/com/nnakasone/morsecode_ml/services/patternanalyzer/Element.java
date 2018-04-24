package ar.com.nnakasone.morsecode_ml.services.patternanalyzer;

import java.util.Objects;

/**
 * @author Nicolas Nakasone
 *
 */

public class Element {

	private Float position; 
	
	private String type;
	
	private String value;

	/**
	 * Constructor de Element
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
	public float distance(Element element) {
		return Math.abs(this.position - element.getPosition());
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

	@Override
	public boolean equals(Object obj) {
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		final Element other = (Element) obj;
		if (!Objects.equals(this.value, other.value)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 89 * hash + Objects.hashCode(this.value);
		return hash;
	}
}
