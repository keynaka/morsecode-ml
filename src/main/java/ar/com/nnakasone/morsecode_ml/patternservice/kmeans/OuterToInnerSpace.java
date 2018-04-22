package ar.com.nnakasone.morsecode_ml.patternservice.kmeans;

import ar.com.nnakasone.morsecode_ml.entities.Binary;

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
		giver = kmeans.getClusters().get(Binary.OUTER_SPACE);
		receiver = kmeans.getClusters().get(Binary.INNER_SPACE);
		selectedElement = giver.getMinElement();
	}
}
