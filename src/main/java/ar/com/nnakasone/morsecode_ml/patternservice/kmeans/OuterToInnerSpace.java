package ar.com.nnakasone.morsecode_ml.patternservice.kmeans;

import ar.com.nnakasone.morsecode_ml.entities.Morse;

/**
 * @author Nicolas Nakasone
 *
 */
public class OuterToInnerSpace extends ChangeStrategy {

	/**
	 * Constructor de Clase
	 * @param kmeans
	 */
	public OuterToInnerSpace(KMeans kmeans) {
		super(kmeans);
		giver = kmeans.getClusters().get(Morse.OUTER_SPACE);
		receiver = kmeans.getClusters().get(Morse.INNER_SPACE);
		selectedElement = giver.getMinElement();
	}
}
