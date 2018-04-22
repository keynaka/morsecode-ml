package ar.com.nnakasone.morsecode_ml.patternservice.kmeans;


/**
 * @author Nicolas Nakasone
 *
 */
public abstract class ChangeStrategy {

	protected KMeans kmeans;
	
	protected Cluster giver;
	
	protected Cluster receiver;
	
	protected Element selectedElement;
	
	/**
	 * Constructor del ChangeStrategy
	 */
	public ChangeStrategy(KMeans kmeans) {
		this.kmeans = kmeans;
	}

	public void change() {
		if (selectedElement != null) {
			receiver.add(selectedElement);
			giver.delete(selectedElement);			
		}
	}
	
	public void undo() {
		if (selectedElement != null) {
			giver.add(selectedElement);
			receiver.delete(selectedElement);
		}
	}
}
