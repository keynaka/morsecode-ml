package ar.com.nnakasone.morsecode_ml.patternservice.kmeans;

import java.util.*;

/**
 * @author Nicolas Nakasone
 *
 */
public class Cluster {

	private Element centroid;
	private List<Element> elements;
	private char type;
	
	/**
	 * 
	 */
	public Cluster(Element centroid, char type) {
		this.centroid = centroid;
		this.type = type;
		this.elements = new ArrayList<Element>();
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public void add(Element element) {
		this.elements.add(element);
		recalculateCentroid();
	}
	
	public void recalculateCentroid() {
		int result = 0;
		
		Iterator<Element> it = elements.iterator();
		int j = 0;
		while(it.hasNext()) {
			result += it.next().getPosition();
			j++;
		}
		this.centroid.setPosition(result/j);
	}
	
	public int calculateDistanceToCentroid(Element element) {
		return element.distance(centroid);
	}
	
	@Override
	public String toString() {
		return ("Centroid: " + centroid.getPosition() + "  Type: " + type);
	}
}
