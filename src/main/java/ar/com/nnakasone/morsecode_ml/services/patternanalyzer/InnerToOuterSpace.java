package ar.com.nnakasone.morsecode_ml.services.patternanalyzer;

import ar.com.nnakasone.morsecode_ml.entities.Morse;

/**
 * @author Nicolas Nakasone
 *
 */

public class InnerToOuterSpace extends ChangeStrategy {

	/**
	 * Constructor de InnerToOuterSpace
	 * @param kmeans
	 */
	public InnerToOuterSpace(KMeans kmeans) {
		super(kmeans);
		giver = kmeans.getClusters().get(Morse.INNER_SPACE);
		receiver = kmeans.getClusters().get(Morse.OUTER_SPACE);
		selectedElement = giver.getMaxElement();
	}
}
