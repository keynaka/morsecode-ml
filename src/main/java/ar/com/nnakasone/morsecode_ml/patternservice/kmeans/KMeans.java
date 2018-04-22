package ar.com.nnakasone.morsecode_ml.patternservice.kmeans;

import java.util.*;

import ar.com.nnakasone.morsecode_ml.entities.Binary;
import ar.com.nnakasone.morsecode_ml.patternservice.PatternAnalyzerService;

/**
 * @author Nicolas Nakasone
 *
 */
public class KMeans implements PatternAnalyzerService{

	private List<Element> elements;
	
	private Map<String, Cluster> clusters;
	
	private Map<String, String> clusterToMorse;
	
	private Queue<ChangeStrategy> options;
	
	/**
	 * Construsctor de KMeans
	 */
	public KMeans(List<String> parsedMessage) {
		initialize(parsedMessage);
		clasify();
		createOptions();
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
		initializeClusterToMorseMap();
	}
	
	private void initializeClusters(List<Element> dotDashElements, List<Element> spaceElements) {
		clusters = new HashMap<String, Cluster>();
		
		Comparator<Element> c = (x, y) -> Float.compare(x.getPosition(), y.getPosition());
		
		clusters.put(Binary.DOT, new Cluster(dotDashElements.stream().min(c).get(), Binary.DOT));
		clusters.put(Binary.DASH, new Cluster(dotDashElements.stream().max(c).get(), Binary.DASH));
		
		clusters.put(Binary.INNER_SPACE, new Cluster(spaceElements.stream().min(c).get(),Binary.INNER_SPACE));
		clusters.put(Binary.OUTER_SPACE, new Cluster(spaceElements.stream().max(c).get(), Binary.OUTER_SPACE));
	}
	
	private void initializeClusterToMorseMap() {
		clusterToMorse = new HashMap<String,String>();
		
		clusterToMorse.put(Binary.DOT, ".");
		clusterToMorse.put(Binary.DASH, "-");
		clusterToMorse.put(Binary.INNER_SPACE, "");
		clusterToMorse.put(Binary.OUTER_SPACE, " ");		
	}
	
	private void clasify() {
		Iterator<Element> it = elements.iterator();
		
		while (it.hasNext()) {
			Element element = it.next();
			nearestCluster(element).add(element);
		}
	}

	private Cluster nearestCluster(Element element) {		
		Iterator<Map.Entry<String,Cluster>> it = clusters.entrySet().iterator();
		
		Cluster minDistanceCluster = null;

		while(it.hasNext()) {
			Cluster cl = it.next().getValue();
			
			if (cl.isSameTypeWith(element)) {
				if (minDistanceCluster == null) {
					minDistanceCluster = cl;
				} else {
					if (minDistanceCluster.calculateDistanceToCentroid(element) > cl.calculateDistanceToCentroid(element)) {
						minDistanceCluster = cl;
					}
				}
			}
		}
		return minDistanceCluster;
	}
	
	private void createOptions() {
		options = new LinkedList<ChangeStrategy>();
		options.add(new DotToDash(this));
		options.add(new DashToDot(this));
		options.add(new InnerToOuterSpace(this));
		options.add(new OuterToInnerSpace(this));
	}
	@Override
	public String determineValue(String value) {
		Iterator<Map.Entry<String,Cluster>> it = clusters.entrySet().iterator();
		boolean found = false;
		String response = "";
		
		while(!found && it.hasNext()) {
			Cluster cl = it.next().getValue();
			if (cl.contains(value)) {
				response = cl.getType();
				found = true;
			}
		}
		return this.clusterToMorse.get(response);
	}

	public Map<String, Cluster> getClusters() {
		return clusters;
	}

	@Override
	public boolean hasOtherOption() {
		return !this.options.isEmpty();
	}

	@Override
	public void change() {
		if (!options.isEmpty())
			this.options.peek().change();
	}

	@Override
	public void undo() {
		if (!options.isEmpty())
			this.options.poll().undo();
	}

}
