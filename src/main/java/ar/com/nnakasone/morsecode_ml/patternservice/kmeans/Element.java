package ar.com.nnakasone.morsecode_ml.patternservice.kmeans;

/**
 * @author Nicolas Nakasone
 *
 */
public class Element {

	private int position;
	private char type;
	private String value;

	/**
	 * 
	 */
	public Element(String value) {
		this.setPosition(value);
		this.setType(value);
		this.setValue(value);
		
	}
	
	public int getPosition() {
		return position;
	}
	
	public void setPosition(String value) {
		this.position = value.length();
	}
	
	public char getType() {
		return type;
	}

	public void setType(String value) {
		this.type = value.charAt(0);
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int distance(Element e) {
		return Math.abs(this.position - e.getPosition());
	}
	
	public int distance(int centroid) {
		return Math.abs(this.position - centroid);
	}

	public void setPosition(int i) {
		this.position = i;
	}
}
