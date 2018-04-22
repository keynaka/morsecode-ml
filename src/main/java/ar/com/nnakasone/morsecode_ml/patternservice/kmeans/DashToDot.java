package ar.com.nnakasone.morsecode_ml.patternservice.kmeans;

import ar.com.nnakasone.morsecode_ml.entities.Binary;

/**
 * @author Nicolas Nakasone
 *
 */
public class DashToDot extends ChangeStrategy {

	/**
	 * Constructor de Clase
	 * @param kmeans
	 */
	public DashToDot(KMeans kmeans) {
		super(kmeans);
		giver = kmeans.getClusters().get(Binary.DASH);
		receiver = kmeans.getClusters().get(Binary.DOT);
		selectedElement = giver.getMinElement();
	}
}
