package ar.com.nnakasone.morsecode_ml.services;

/**
 * Interfaz del servicio utilizado para determinar los patrones asociados a un mensaje
 * @author Nicolas Nakasone
 */
public interface PatternAnalyzerService {
	
	public String determineValue(String value);
	public boolean hasOtherOption();
	public void change();
	public void undo();
	
}
