package ar.com.nnakasone.morsecode_ml.services.patternanalyzer;

import java.util.*;
import ar.com.nnakasone.morsecode_ml.entities.Morse;

/**
 * @author Nicolas Nakasone
 *
 */

public class Cluster {

	private Element centroid;
	
	private Set<Element> elements;
	
	private String type;
	
	/**
	 * Constructor de Cluster
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

	/**
	 * Agrega al elemento al Cluster y recalcula el centroide
	 * @param element
	 */
	public void add(Element newElement) {
		this.elements.add(newElement);
		recalculateCentroid();
	}
	
	/**
	 * Elimina al elemento seleccionado del Cluster y recalcula el centroide
	 * @param selectedElement
	 */
	public void delete(Element selectedElement) {
		this.elements.remove(selectedElement);
		recalculateCentroid();
	}
	
	/**
	 * Recalcula la posicion del centroide dependiendo de los elementos que tiene el Cluster y la cantidad.
	 */
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
	
	/**
	 * Calcula la distancia del centroide de este cluster a un cierto elemento
	 * @param element
	 * @return
	 */
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
	
	/**
	 * Devuelve si un elemento es del mismo tipo que el de este cluster. 
	 * Recordar que los elementos no saben si son:
	 * 	DASH/DOT
	 * 	INNER_SPACE/OUTER_SPACE
	 * Solo saben que son o 1 o 0;
	 * 
	 * @param element
	 * @return
	 */
	public boolean isSameTypeWith(Element element) {
		Map<String,String> map = new HashMap<String,String>();
		
		map.put(Morse.DOT, "1");
		map.put(Morse.DASH, "1");
		map.put(Morse.INNER_SPACE, "0");
		map.put(Morse.OUTER_SPACE, "0");
			
		return (element.getType().equals(map.get(this.type)));
	}

	/**
	 * Devuelve si el cluster contiene a algun elemento que tenga dicho valor
	 * @param value
	 * @return answer
	 */
	public boolean contains(String value) {
		Iterator<Element> it = elements.iterator();
		while (it.hasNext()) {
			if (it.next().getValue().equals(value)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Devuelve si el Cluster se encuentra vacio
	 * @return
	 */
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
