package ar.com.nnakasone.morsecode_ml.patternservice.kmeans;

import java.util.*;

/**
 * @author Nicolas Nakasone
 *
 */
public class Cluster {

	private Element centroid;
	private List<Element> elements;
	private String type;
	
	
	private final static String DOT = "DOT";
	
	private final static String DASH = "DASH";
	
	private final static String INNER_SPACE = "INNER_SPACE";
	
	private final static String OUTER_SPACE = "OUTER_SPACE";
	
	/**
	 * 
	 */
	public Cluster(Element centroid, String type) {
		this.centroid = centroid;
		this.type = type;
		this.elements = new ArrayList<Element>();
	}
	
	public Cluster() {
		this.elements = new ArrayList<Element>();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void add(Element element) {
		this.elements.add(element);
		recalculateCentroid();
	}
	
	public void recalculateCentroid() {
		float result = centroid.getPosition();
		
		Iterator<Element> it = elements.iterator();
		int j = 1;
		while(it.hasNext()) {
			result += it.next().getPosition();
			j++;
		}
		this.centroid.setPosition(result/j);
	}
	
	public float calculateDistanceToCentroid(Element element) {
		return element.distance(centroid);
	}
	
	@Override
	public String toString() {
		String clusterInfo = "Centroid: " + centroid.getPosition() + "  Type: " + type;

		clusterInfo = clusterInfo.concat("\nElements:\n");
		Iterator<Element> it = elements.iterator();
		while (it.hasNext()) {
			clusterInfo = clusterInfo.concat(it.next().getValue() + "\n");
		}
		
		return clusterInfo;
	}

	public boolean isSameTypeWith(Element element) {
		Map<String,String> map = new HashMap<String,String>();
		
		map.put(DOT, "1");
		map.put(DASH, "1");
		map.put(INNER_SPACE, "0");
		map.put(OUTER_SPACE, "0");
			
		return (element.getType().equals(map.get(this.type)));
		
	}
}
