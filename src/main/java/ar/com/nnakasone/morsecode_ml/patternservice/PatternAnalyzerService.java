package ar.com.nnakasone.morsecode_ml.patternservice;

/**
 * @author Nicolas Nakasone
 *
 */
public interface PatternAnalyzerService {
	public String determineValue(String value);
	public boolean hasOtherOption();
	public void change();
	public void undo();
}
