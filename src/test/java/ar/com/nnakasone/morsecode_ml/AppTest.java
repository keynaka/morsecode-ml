package ar.com.nnakasone.morsecode_ml;

import ar.com.nnakasone.morsecode_ml.controller.TranslatorController;
import ar.com.nnakasone.morsecode_ml.dto.MessageRequest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AppTest {
	
	private TranslatorController translatorController;
	
	private MessageRequest messageRequest;
	
	@Before
	public void initialize() {
		translatorController = new TranslatorController();
		messageRequest = new MessageRequest();
	}
	
	/* -----------------------Test de Metodo: translate2Human()------------------------------ */
	
	@Test
	public void testHolaMeliMorseCodeShouldGiveAHolaMeliHumanCode() {
		messageRequest.setValue(".... --- .-.. .- -- . .-.. ..");
		translatorController.setMessage(messageRequest);
		
		Assert.assertEquals("HOLAMELI", this.translatorController.translate2Human());
	}
	
	@Test
	public void testHolaMeliWithSpaceMorseCodeShouldGiveAHolaMeliWithSpaceHumanCode() {
		messageRequest.setValue(".... --- .-.. .-  -- . .-.. ..");
		translatorController.setMessage(messageRequest);
		
		Assert.assertEquals("HOLA MELI", this.translatorController.translate2Human());
	}
	
	@Test
	public void testHolaMeliWithTripeSpaceMorseCodeShouldGiveAHolaMeliWithTripleSpaceHumanCode() {
		messageRequest.setValue(".... --- .-.. .-    -- . .-.. ..");
		translatorController.setMessage(messageRequest);
		
		Assert.assertEquals("HOLA   MELI", this.translatorController.translate2Human());
	}
	
	@Test
	public void testAlphabetInMorseCodeShouldGiveAlphabetInHumanCode() {
		messageRequest.setValue(".- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- --..");
		translatorController.setMessage(messageRequest);
		
		Assert.assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", this.translatorController.translate2Human());
	}
	
	@Test
	public void testNumbersInMorseCodeShouldGiveNumbersInHumanCode() {
		messageRequest.setValue("----- .---- ..--- ...-- ....- ..... -.... --... ---.. ----.");
		translatorController.setMessage(messageRequest);
		
		Assert.assertEquals("0123456789", this.translatorController.translate2Human());
	}
	
	@Test
	public void testNonExistentMorseCodeShouldAnEmptyAnswer() {
		messageRequest.setValue("------");
		translatorController.setMessage(messageRequest);
		
		Assert.assertEquals("", this.translatorController.translate2Human());
	}
	
	/* -----------------------Test de Metodo: translate2Morse()------------------------------ */ 
	
	@Test
	public void testHolaMeliHumanCodeShouldGiveAHolaMeliMorseCode() {
		messageRequest.setValue("HOLAMELI");
		translatorController.setMessage(messageRequest);
		
		Assert.assertEquals(".... --- .-.. .- -- . .-.. ..", this.translatorController.translate2Morse());
	}
	
	@Test
	public void testHolaMeliInUnderCaseHumanCodeShouldGiveAHolaMeliMorseCode() {
		messageRequest.setValue("holameli");
		translatorController.setMessage(messageRequest);
		
		Assert.assertEquals(".... --- .-.. .- -- . .-.. ..", this.translatorController.translate2Morse());
	}
	
	@Test
	public void testHolaMeliWithSpaceHumanCodeShouldGiveAHolaMeliWithSpaceMorseCode() {
		messageRequest.setValue("HOLA MELI");
		translatorController.setMessage(messageRequest);
		
		Assert.assertEquals(".... --- .-.. .-  -- . .-.. ..", this.translatorController.translate2Morse());
	}
	
	@Test
	public void testHolaMeliWithTripeSpaceHumanCodeShouldGiveAHolaMeliWithTripleSpaceMorseCode() {
		messageRequest.setValue("HOLA   MELI");
		translatorController.setMessage(messageRequest);
		
		Assert.assertEquals(".... --- .-.. .-    -- . .-.. ..", this.translatorController.translate2Morse());
	}
	
	@Test
	public void testHolaMeliHumanWithExclamationMarkCodeShouldGiveAnEmptyAnswer() {
		messageRequest.setValue("HOLAMELI!");
		translatorController.setMessage(messageRequest);
		
		Assert.assertEquals("", this.translatorController.translate2Morse());
	}
	
	@Test
	public void testAlphabetInHumanCodeShouldGiveAlphabetInMorseCode() {
		messageRequest.setValue("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		translatorController.setMessage(messageRequest);
		
		Assert.assertEquals(".- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- --..", this.translatorController.translate2Morse());
	}
	
	@Test
	public void testNumbersInHumanCodeShouldGiveNumbersInMorseCode() {
		messageRequest.setValue("0123456789");
		translatorController.setMessage(messageRequest);
		
		Assert.assertEquals("----- .---- ..--- ...-- ....- ..... -.... --... ---.. ----.", this.translatorController.translate2Morse());
	}
	
	/* -----------------------Test de Metodo: decodeBits2Morse()------------------------------ */ 
	
	@Test
	public void testHolaBinaryCodeShouldGiveAHolaMorseCode() {
		messageRequest.setValue("000000000000110011011001100000011111110111111111110111111111000000000010111111110110011000000010111111100000000");
		translatorController.setMessage(messageRequest);
		
		Assert.assertEquals(".... --- .-.. .-", this.translatorController.decodeBits2Morse());
	}
	
	@Test
	public void testXInBinaryCodeWithoutNoiseShouldGiveXiInMorseCode() {
		messageRequest.setValue("1111111111010101111111");
		translatorController.setMessage(messageRequest);
		
		Assert.assertEquals("-..-", this.translatorController.decodeBits2Morse());
	}
	
	@Test
	public void testNoMatterHowManyNoiseHasAnXInBinaryCodeItShouldGiveAnXInMorseCode() {
		messageRequest.setValue("00000000000000000000000000000000000000000000000000000000000000000111111111111010101111111111000000000000000000000000000000000000000000000");
		translatorController.setMessage(messageRequest);
		
		Assert.assertEquals("-..-", this.translatorController.decodeBits2Morse());
	}
	
	
	/**
	 * En este test los 2 ceros consecutivos ("00") son mas interpretables como una separacion entre . y -, que una separacion entre caracteres morse. 
	 * Sin embargo deberia dar una respuesta apropiada buscando otra alternativa. 
	 */
	@Test
	public void testMisinterpretableElementShouldGiveApropiateAnswer() {
		messageRequest.setValue("101010101001000001");
		translatorController.setMessage(messageRequest);
		
		Assert.assertEquals("..... . .", this.translatorController.decodeBits2Morse());
	}
}
