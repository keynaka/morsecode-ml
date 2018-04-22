package ar.com.nnakasone.morsecode_ml.patternservice.kmeans;

import ar.com.nnakasone.morsecode_ml.entities.Binary;

/**
 * @author Nicolas Nakasone
 *
 */
public class DotToDash extends ChangeStrategy {

	/**
	 * Constructor de Clase
	 * @param kmeans
	 */
	public DotToDash(KMeans kmeans) {
		super(kmeans);
		giver = kmeans.getClusters().get(Binary.DOT);
		receiver = kmeans.getClusters().get(Binary.DASH);
		selectedElement = giver.getMaxElement();
	}
}
