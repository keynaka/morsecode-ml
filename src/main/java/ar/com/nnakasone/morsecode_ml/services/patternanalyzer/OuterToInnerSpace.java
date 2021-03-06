package ar.com.nnakasone.morsecode_ml.services.patternanalyzer;

import ar.com.nnakasone.morsecode_ml.entities.Morse;

/**
 * @author Nicolas Nakasone
 *
 */

public class OuterToInnerSpace extends ChangeStrategy {

	/**
	 * Constructor de OuterToInnerSpace
	 * @param kmeans
	 */
	public OuterToInnerSpace(KMeans kmeans) {
		super(kmeans);
		giver = kmeans.getClusters().get(Morse.OUTER_SPACE);
		receiver = kmeans.getClusters().get(Morse.INNER_SPACE);
		selectedElement = giver.getMinElement();
	}
}
