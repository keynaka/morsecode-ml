package ar.com.nnakasone.morsecode_ml.patternservice.kmeans;

import ar.com.nnakasone.morsecode_ml.entities.Binary;

/**
 * @author Nicolas Nakasone
 *
 */
public class InnerToOuterSpace extends ChangeStrategy {

	/**
	 * Constructor de Clase
	 * @param kmeans
	 */
	public InnerToOuterSpace(KMeans kmeans) {
		super(kmeans);
		giver = kmeans.getClusters().get(Binary.INNER_SPACE);
		receiver = kmeans.getClusters().get(Binary.OUTER_SPACE);
		selectedElement = giver.getMaxElement();
	}
}
