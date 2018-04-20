package ar.com.nnakasone.morsecode_ml.patternservice;

/**
 * @author Nicolas Nakasone
 *
 */
public interface PatternAnalyzerService {
	public String determineValue(String value);
	public boolean isOnlyOption();
	public void swap();
}
