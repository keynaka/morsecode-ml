package ar.com.nnakasone.morsecode_ml.patternservice.kmeans;

import ar.com.nnakasone.morsecode_ml.entities.Morse;

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
		giver = kmeans.getClusters().get(Morse.DASH);
		receiver = kmeans.getClusters().get(Morse.DOT);
		selectedElement = giver.getMinElement();
	}
}
