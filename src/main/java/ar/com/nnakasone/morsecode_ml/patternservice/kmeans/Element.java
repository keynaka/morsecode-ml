package ar.com.nnakasone.morsecode_ml.patternservice.kmeans;

/**
 * @author Nicolas Nakasone
 *
 */
public class Element {

	private Float position;
	private String type;
	private String value;

	/**
	 * 
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

	public float distance(Element e) {
		return Math.abs(this.position - e.getPosition());
	}
	
	public float distance(int centroid) {
		return Math.abs(this.position - centroid);
	}

	public void setPosition(float i) {
		this.position = i;
	}
}
