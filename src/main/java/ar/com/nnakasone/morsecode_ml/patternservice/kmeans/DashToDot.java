package ar.com.nnakasone.morsecode_ml.patternservice.kmeans;

/**
 * @author Nicolas Nakasone
 *
 */
public class DashToDot extends ChangeStrategy {

	/**
	 * @param kmeans
	 */
	public DashToDot(KMeans kmeans) {
		super(kmeans);
		giver = kmeans.getClusters().get("DASH");
		receiver = kmeans.getClusters().get("DOT");
		selectedElement = giver.getMinElement();
	}
}
