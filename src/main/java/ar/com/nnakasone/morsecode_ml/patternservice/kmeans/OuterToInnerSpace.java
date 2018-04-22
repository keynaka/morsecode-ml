package ar.com.nnakasone.morsecode_ml.patternservice.kmeans;

/**
 * @author Nicolas Nakasone
 *
 */
public class OuterToInnerSpace extends ChangeStrategy {

	/**
	 * @param kmeans
	 */
	public OuterToInnerSpace(KMeans kmeans) {
		super(kmeans);
		giver = kmeans.getClusters().get("OUTER_SPACE");
		receiver = kmeans.getClusters().get("INNER_SPACE");
		selectedElement = giver.getMinElement();
	}
}
