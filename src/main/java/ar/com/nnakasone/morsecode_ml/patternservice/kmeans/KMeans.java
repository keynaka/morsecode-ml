package ar.com.nnakasone.morsecode_ml.patternservice.kmeans;

import java.util.*;

/**
 * @author Nicolas Nakasone
 *
 */
public class KMeans {

	private List<Element> dotDashElements;
	
	private List<Element> spaceElements;
	
	private Cluster dotCluster;
	
	private Cluster dashCluster;
	
	private Cluster innerSpaceCluster;
	
	private Cluster outerSpaceCluster;
	
	/**
	 * 
	 */
	public KMeans(List<String> parsedMessage) {
		chargeElements(parsedMessage);
		initializeClusters();
	}

	private void initializeClusters() {
		Comparator<Element> c = (x, y) -> Integer.compare(x.getPosition(), y.getPosition());
		
		dotCluster = new Cluster(dotDashElements.stream().min(c).get(),'1');
		dashCluster = new Cluster(dotDashElements.stream().max(c).get(),'1');
		
		innerSpaceCluster = new Cluster(spaceElements.stream().min(c).get(),'0');
		outerSpaceCluster = new Cluster(spaceElements.stream().max(c).get(),'0');
	}

	private void chargeElements(List<String> parsedMessage) {
		dotDashElements = new ArrayList<Element>();
		spaceElements = new ArrayList<Element>();
		
		Iterator<String> it = parsedMessage.iterator();
		while (it.hasNext()) {
			String element = it.next();
			if (element.charAt(0) == '1') {
				dotDashElements.add(new Element(element));				
			} else {
				spaceElements.add(new Element(element));
			}
		}
	}

	public Cluster getDotCluster() {
		return dotCluster;
	}

	public void setDotCluster(Cluster dotCluster) {
		this.dotCluster = dotCluster;
	}

	public Cluster getDashCluster() {
		return dashCluster;
	}

	public void setDashCluster(Cluster dashCluster) {
		this.dashCluster = dashCluster;
	}

	public Cluster getInnerSpaceCluster() {
		return innerSpaceCluster;
	}

	public void setInnerSpaceCluster(Cluster innerSpaceCluster) {
		this.innerSpaceCluster = innerSpaceCluster;
	}

	public Cluster getOuterSpaceCluster() {
		return outerSpaceCluster;
	}

	public void setOuterSpaceCluster(Cluster outerSpaceCluster) {
		this.outerSpaceCluster = outerSpaceCluster;
	}
	
	

		
}
