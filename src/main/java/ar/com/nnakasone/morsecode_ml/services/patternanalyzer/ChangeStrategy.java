package ar.com.nnakasone.morsecode_ml.services.patternanalyzer;


/**
 * @author Nicolas Nakasone
 *
 */
public abstract class ChangeStrategy {

	protected KMeans kmeans;
	
	protected Cluster giver;
	
	protected Cluster receiver;
	
	protected Element selectedElement;
	
	private boolean changed;
	
	/**
	 * Constructor de ChangeStrategy
	 */
	public ChangeStrategy(KMeans kmeans) {
		this.kmeans = kmeans;
		this.changed = false;
	}

	/**
	 * Cambia de lugar un elemento borde de un cluster, dependiendo la estrategia implementada
	 */
	public void change() {
		if (selectedElement != null) {
			receiver.add(selectedElement);
			giver.delete(selectedElement);	
			this.changed = true;
		}
	}
	
	/**
	 * Deshace el cambio realizado
	 * @see 
	 */
	public void undo() {
		if (changed) {
			if (selectedElement != null) {
				giver.add(selectedElement);
				receiver.delete(selectedElement);
			}	
		}
	}
}
