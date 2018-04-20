package ar.com.nnakasone.morsecode_ml.patternservice.kmeans;

import java.util.*;

/**
 * @author Nicolas Nakasone
 *
 */
public class KMeans {

	private List<Element> elements;
	
	private List<Cluster> clusters;
	
	private final static String DOT = "DOT";
	
	private final static String DASH = "DASH";
	
	private final static String INNER_SPACE = "INNER_SPACE";
	
	private final static String OUTER_SPACE = "OUTER_SPACE";
			
	/**
	 * 
	 */
	public KMeans(List<String> parsedMessage) {
		initialize(parsedMessage);
		clasify();
	}

	private void clasify() {
		Iterator<Element> it = elements.iterator();
		
		while (it.hasNext()) {
			Element element = it.next();
			nearestCluster(element).add(element);
		}
	}

	private Cluster nearestCluster(Element element) {		
		Iterator<Cluster> it = clusters.iterator();
		
		Cluster minDistanceCluster = null;

		while(it.hasNext()) {
			Cluster cl = it.next();
			
			if (cl.isSameTypeWith(element)) {
				if (minDistanceCluster == null) {
					minDistanceCluster = cl;
				} else {
					if (minDistanceCluster.calculateDistanceToCentroid(element) >= cl.calculateDistanceToCentroid(element)) {
						minDistanceCluster = cl;
					}
				}
			}
		}
		return minDistanceCluster;
	}

	private void initialize(List<String> parsedMessage) {
		List<Element> dotDashElements = new ArrayList<Element>();
		List<Element> spaceElements = new ArrayList<Element>();
		elements = new ArrayList<Element>();
		
		Iterator<String> it = parsedMessage.iterator();
		while (it.hasNext()) {
			String element = it.next();
			if (element.charAt(0) == '1') {
				dotDashElements.add(new Element(element));				
			} else {
				spaceElements.add(new Element(element));
			}
			elements.add(new Element(element));
		}
		initializeClusters(dotDashElements, spaceElements);
	}
	
	private void initializeClusters(List<Element> dotDashElements, List<Element> spaceElements) {
		clusters = new ArrayList<Cluster>();
		
		Comparator<Element> c = (x, y) -> Float.compare(x.getPosition(), y.getPosition());
		
		clusters.add(new Cluster(dotDashElements.stream().min(c).get(), DOT));
		clusters.add(new Cluster(dotDashElements.stream().max(c).get(), DASH));
		
		clusters.add(new Cluster(spaceElements.stream().min(c).get(),INNER_SPACE));
		clusters.add(new Cluster(spaceElements.stream().max(c).get(), OUTER_SPACE));
	}
	
	public void showClusters() {
		Iterator<Cluster> it = clusters.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
