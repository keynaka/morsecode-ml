package ar.com.nnakasone.morsecode_ml.patternservice.kmeans;

import java.util.*;

/**
 * @author Nicolas Nakasone
 *
 */
public class Cluster {

	private Element centroid;
	
	private Set<Element> elements;
	
	private String type;
	
	private final static String DOT = "DOT";
	
	private final static String DASH = "DASH";
	
	private final static String INNER_SPACE = "INNER_SPACE";
	
	private final static String OUTER_SPACE = "OUTER_SPACE";
	
	/**
	 * Constructor de Clase Cluster
	 */
	public Cluster(Element centroid, String type) {
		this.centroid = centroid;
		this.type = type;
		this.elements = new HashSet<Element>();
	}
	
	public Cluster() {
		this.elements = new HashSet<Element>();
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
	
	public void delete(Element selectedElement) {
		this.elements.remove(selectedElement);
		recalculateCentroid();
	}
	
	public void recalculateCentroid() {
		float result = centroid.getPosition();
		int j = 1;
		
		if (!this.elements.isEmpty()) {
			Iterator<Element> it = elements.iterator();
			while(it.hasNext()) {
				result += it.next().getPosition();
				j++;
			}
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

	public boolean contains(String value) {
		Iterator<Element> it = elements.iterator();
		while (it.hasNext()) {
			if (it.next().getValue().equals(value)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isEmpty() {
		return elements.isEmpty();
	}
	
	/**
	 * Devuelve el minimo elemento, siempre que el cluster no este vacio.
	 * Si esta vacio devolvera null.
	 * 
	 * @
	 * @return minElement
	 */
	public Element getMinElement() {
		if (elements.isEmpty())
			return null;
		Iterator<Element> it = elements.iterator();
		Element minElement = it.next();
		while(it.hasNext()) {
			Element actualElement = it.next();
			if (minElement.getPosition() > actualElement.getPosition()) {
				minElement = actualElement;
			}
		}
		return minElement;
	}
	
	/**
	 * Devuelve el maximo elemento, siempre que el cluster no este vacio.
	 * Si esta vacio devolvera null.
	 * 
	 * @
	 * @return minElement
	 */
	public Element getMaxElement() {
		if (elements.isEmpty())
			return null;
		Iterator<Element> it = elements.iterator();
		Element maxElement = it.next();
		while(it.hasNext()) {
			Element actualElement = it.next();
			if (maxElement.getPosition() < actualElement.getPosition()) {
				maxElement = actualElement;
			}
		}
		return maxElement;
	}
}
