package ar.com.nnakasone.morsecode_ml.services.patternanalyzer;

import ar.com.nnakasone.morsecode_ml.entities.Morse;

/**
 * @author Nicolas Nakasone
 *
 */

public class DotToDash extends ChangeStrategy {

	/**
	 * Constructor de DotToDash
	 * @param kmeans
	 */
	public DotToDash(KMeans kmeans) {
		super(kmeans);
		giver = kmeans.getClusters().get(Morse.DOT);
		receiver = kmeans.getClusters().get(Morse.DASH);
		selectedElement = giver.getMaxElement();
	}
}
