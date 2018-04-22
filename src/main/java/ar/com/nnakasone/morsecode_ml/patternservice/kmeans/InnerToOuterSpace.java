package ar.com.nnakasone.morsecode_ml.patternservice.kmeans;

/**
 * @author Nicolas Nakasone
 *
 */
public class InnerToOuterSpace extends ChangeStrategy {

	/**
	 * @param kmeans
	 */
	public InnerToOuterSpace(KMeans kmeans) {
		super(kmeans);
		giver = kmeans.getClusters().get("INNER_SPACE");
		receiver = kmeans.getClusters().get("OUTER_SPACE");
		selectedElement = giver.getMaxElement();
	}
}
