package ar.com.nnakasone.morsecode_ml.patternservice.kmeans;

/**
 * @author Nicolas Nakasone
 *
 */
public class DotToDash extends ChangeStrategy {

	/**
	 * @param kmeans
	 */
	public DotToDash(KMeans kmeans) {
		super(kmeans);
		giver = kmeans.getClusters().get("DOT");
		receiver = kmeans.getClusters().get("DASH");
		selectedElement = giver.getMaxElement();
	}
}
