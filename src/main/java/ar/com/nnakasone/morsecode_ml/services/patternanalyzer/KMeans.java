package ar.com.nnakasone.morsecode_ml.services.patternanalyzer;

import java.util.*;

import ar.com.nnakasone.morsecode_ml.entities.Morse;
import ar.com.nnakasone.morsecode_ml.services.PatternAnalyzerService;

/**
 * @author Nicolas Nakasone
 *
 */
public class KMeans implements PatternAnalyzerService{

	private List<Element> elements;
	
	private Map<String, Cluster> clusters;
	
	private Queue<ChangeStrategy> options;
	
	/**
	 * Constructor de KMeans
	 */
	public KMeans(List<String> parsedMessage) {
		initialize(parsedMessage);
		clasify();
		createOptions();
	}

	/**
	 * Inicializa los elementos necesarios para la corrida del KMeans
	 * @param parsedMessage
	 */
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
	
	/**
	 * Inicializa cada uno de los 4 clusters
	 * @param dotDashElements
	 * @param spaceElements
	 */
	private void initializeClusters(List<Element> dotDashElements, List<Element> spaceElements) {
		clusters = new HashMap<String, Cluster>();
		
		Comparator<Element> c = (x, y) -> Float.compare(x.getPosition(), y.getPosition());
		
		clusters.put(Morse.DOT, new Cluster(dotDashElements.stream().min(c).get(), Morse.DOT));
		clusters.put(Morse.DASH, new Cluster(dotDashElements.stream().max(c).get(), Morse.DASH));
		
		clusters.put(Morse.INNER_SPACE, new Cluster(spaceElements.stream().min(c).get(),Morse.INNER_SPACE));
		clusters.put(Morse.OUTER_SPACE, new Cluster(spaceElements.stream().max(c).get(), Morse.OUTER_SPACE));
	}
	
	/**
	 * Clasifica cada uno de los elementos al cluster mas cercano
	 */
	private void clasify() {
		Iterator<Element> it = elements.iterator();
		
		while (it.hasNext()) {
			Element element = it.next();
			nearestCluster(element).add(element);
		}
	}

	/**
	 * Devuelve el cluster el cual sea del mismo tipo y la distancia de su posicion al centroide del cluster sea la mas cercana
	 * @param element
	 * @return
	 */
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
	
	/**
	 * Carga los posibles tipos de estrategias para cambios que se puedan implementar para reajustar los clusters
	 */
	private void createOptions() {
		options = new LinkedList<ChangeStrategy>();
		options.add(new DotToDash(this));
		options.add(new DashToDot(this));
		options.add(new InnerToOuterSpace(this));
		options.add(new OuterToInnerSpace(this));
	}
	
	/**
	 * Devuelve el valor de un elemento en binario en morse
	 */
	@Override
	public String determineValue(String value) {
		Morse morse = new Morse();
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
		return morse.getMorse(response);
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
