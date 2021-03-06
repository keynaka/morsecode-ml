package ar.com.nnakasone.morsecode_ml;

import ar.com.nnakasone.morsecode_ml.controller.TranslatorController;
import ar.com.nnakasone.morsecode_ml.dto.MessageRequest;
import ar.com.nnakasone.morsecode_ml.exception.UnknownCodeException;
import ar.com.nnakasone.morsecode_ml.services.ParseService;
import ar.com.nnakasone.morsecode_ml.services.TranslateService;
import ar.com.nnakasone.morsecode_ml.services.parser.MorseParser;
import ar.com.nnakasone.morsecode_ml.services.parser.RomanParser;
import ar.com.nnakasone.morsecode_ml.services.translator.MorseToRomanTranslator;
import ar.com.nnakasone.morsecode_ml.services.translator.RomanToMorseTranslator;

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
		
		Assert.assertEquals("HOLAMELI", this.translatorController.translate2Human(messageRequest).getResponse());
	}
	
	@Test
	public void testHolaMeliWithSpaceMorseCodeShouldGiveAHolaMeliWithSpaceHumanCode() {
		messageRequest.setValue(".... --- .-.. .-  -- . .-.. ..");
		
		Assert.assertEquals("HOLA MELI", this.translatorController.translate2Human(messageRequest).getResponse());
	}
	
	@Test
	public void testHolaMeliWithTripeSpaceMorseCodeShouldGiveAHolaMeliWithTripleSpaceHumanCode() {
		messageRequest.setValue(".... --- .-.. .-    -- . .-.. ..");
		
		Assert.assertEquals("HOLA   MELI", this.translatorController.translate2Human(messageRequest).getResponse());
	}
	
	@Test
	public void testAlphabetInMorseCodeShouldGiveAlphabetInHumanCode() {
		messageRequest.setValue(".- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- --..");
		
		Assert.assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ", this.translatorController.translate2Human(messageRequest).getResponse());
	}
	
	@Test
	public void testNumbersInMorseCodeShouldGiveNumbersInHumanCode() {
		messageRequest.setValue("----- .---- ..--- ...-- ....- ..... -.... --... ---.. ----.");
		
		Assert.assertEquals("0123456789", this.translatorController.translate2Human(messageRequest).getResponse());
	}
	
	@Test
	public void testNonExistentMorseCodeShouldAnEmptyAnswer() {
		boolean thrown = false;
		
		messageRequest.setValue("------");
		ParseService ps = new MorseParser(messageRequest);
		TranslateService ts = new MorseToRomanTranslator(ps.parse());
		
		try {
			ts.translate();
		} catch	(UnknownCodeException uce) {
			thrown = true;
		}
		Assert.assertTrue(thrown);
	}
	
	/* -----------------------Test de Metodo: translate2Morse()------------------------------ */ 
	
	@Test
	public void testHolaMeliHumanCodeShouldGiveAHolaMeliMorseCode() {
		messageRequest.setValue("HOLAMELI");
		
		Assert.assertEquals(".... --- .-.. .- -- . .-.. ..", this.translatorController.translate2Morse(messageRequest).getResponse());
	}
	
	@Test
	public void testHolaMeliInUnderCaseHumanCodeShouldGiveAHolaMeliMorseCode() {
		messageRequest.setValue("holameli");
		
		Assert.assertEquals(".... --- .-.. .- -- . .-.. ..", this.translatorController.translate2Morse(messageRequest).getResponse());
	}
	
	@Test
	public void testHolaMeliWithSpaceHumanCodeShouldGiveAHolaMeliWithSpaceMorseCode() {
		messageRequest.setValue("HOLA MELI");
		
		Assert.assertEquals(".... --- .-.. .-  -- . .-.. ..", this.translatorController.translate2Morse(messageRequest).getResponse());
	}
	
	@Test
	public void testHolaMeliWithTripeSpaceHumanCodeShouldGiveAHolaMeliWithTripleSpaceMorseCode() {
		messageRequest.setValue("HOLA   MELI");
		
		Assert.assertEquals(".... --- .-.. .-    -- . .-.. ..", this.translatorController.translate2Morse(messageRequest).getResponse());
	}
	
	@Test
	public void testHolaMeliHumanWithExclamationMarkCodeShouldGiveAnEmptyAnswer() {
		boolean thrown = false;

		messageRequest.setValue("HOLAMELI!");
		ParseService ps = new RomanParser(messageRequest);
		TranslateService ts = new RomanToMorseTranslator(ps.parse());
		
		try {
			ts.translate();
		} catch	(UnknownCodeException uce) {
			thrown = true;
		}
		Assert.assertTrue(thrown);
	}
	
	@Test
	public void testAlphabetInHumanCodeShouldGiveAlphabetInMorseCode() {
		messageRequest.setValue("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		
		Assert.assertEquals(".- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- --..", this.translatorController.translate2Morse(messageRequest).getResponse());
	}
	
	@Test
	public void testNumbersInHumanCodeShouldGiveNumbersInMorseCode() {
		messageRequest.setValue("0123456789");
		
		Assert.assertEquals("----- .---- ..--- ...-- ....- ..... -.... --... ---.. ----.", this.translatorController.translate2Morse(messageRequest).getResponse());
	}
	
	/* -----------------------Test de Metodo: decodeBits2Morse()------------------------------ */ 
	
	@Test
	public void testHolaBinaryCodeShouldGiveAHolaMorseCode() {
		messageRequest.setValue("000000000000110011011001100000011111110111111111110111111111000000000010111111110110011000000010111111100000000");
		
		Assert.assertEquals(".... --- .-.. .-", this.translatorController.decodeBits2Morse(messageRequest).getResponse());
	}
	
	@Test
	public void testXInBinaryCodeWithoutNoiseShouldGiveXiInMorseCode() {
		messageRequest.setValue("1111111111010101111111");
		
		Assert.assertEquals("-..-", this.translatorController.decodeBits2Morse(messageRequest).getResponse());
	}
	
	@Test
	public void testNoMatterHowManyNoiseHasAnXInBinaryCodeItShouldGiveAnXInMorseCode() {
		messageRequest.setValue("00000000000000000000000000000000000000000000000000000000000000000111111111111010101111111111000000000000000000000000000000000000000000000");
		
		Assert.assertEquals("-..-", this.translatorController.decodeBits2Morse(messageRequest).getResponse());
	}
	
	
	/**
	 * En este test los 2 ceros consecutivos ("00") son mas interpretables como una separacion entre . y -, que una separacion entre caracteres morse. 
	 * Sin embargo deberia dar una respuesta apropiada buscando otra alternativa. 
	 */
	@Test
	public void testMisinterpretableElementShouldGiveApropiateAnswer() {
		messageRequest.setValue("101010101001000001");
		
		Assert.assertEquals("..... . .", this.translatorController.decodeBits2Morse(messageRequest).getResponse());
	}
}
