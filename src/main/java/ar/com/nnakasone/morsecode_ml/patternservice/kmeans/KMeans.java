package ar.com.nnakasone.morsecode_ml.patternservice.kmeans;

import java.util.*;

import ar.com.nnakasone.morsecode_ml.patternservice.PatternAnalyzerService;

/**
 * @author Nicolas Nakasone
 *
 */
public class KMeans implements PatternAnalyzerService{

	private List<Element> elements;
	
	private List<Cluster> clusters;
	
	private Map<String, String> clusterToMorse;
	
	private final String DOT = "DOT";
	
	private final String DASH = "DASH";
	
	private final String INNER_SPACE = "INNER_SPACE";
	
	private final String OUTER_SPACE = "OUTER_SPACE";
			
	/**
	 * 
	 */
	public KMeans(List<String> parsedMessage) {
		initialize(parsedMessage);
		clasify();
	}

	private void initializeClusterToMorse() {
		clusterToMorse = new HashMap<String,String>();
		
		clusterToMorse.put(DOT, ".");
		clusterToMorse.put(DASH, "-");
		clusterToMorse.put(INNER_SPACE, "");
		clusterToMorse.put(OUTER_SPACE, " ");		
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
		initializeClusterToMorse();
	}
	
	private void initializeClusters(List<Element> dotDashElements, List<Element> spaceElements) {
		clusters = new ArrayList<Cluster>();
		
		Comparator<Element> c = (x, y) -> Float.compare(x.getPosition(), y.getPosition());
		
		clusters.add(new Cluster(dotDashElements.stream().min(c).get(), DOT));
		clusters.add(new Cluster(dotDashElements.stream().max(c).get(), DASH));
		
		clusters.add(new Cluster(spaceElements.stream().min(c).get(),INNER_SPACE));
		clusters.add(new Cluster(spaceElements.stream().max(c).get(), OUTER_SPACE));
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
	
	public void showClusters() {
		Iterator<Cluster> it = clusters.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	@Override
	public String determineValue(String value) {
		Iterator<Cluster> it = clusters.iterator();
		boolean found = false;
		String response = "";
		
		while(!found && it.hasNext()) {
			Cluster cl = it.next();
			if (cl.contains(value)) {
				response = cl.getType();
				found = true;
			}
		}
		return this.clusterToMorse.get(response);
	}

	@Override
	public boolean isOnlyOption() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void swap() {
		// TODO Auto-generated method stub
		
	}

}
