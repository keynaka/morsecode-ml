package ar.com.nnakasone.morsecode_ml.logger;

import java.io.IOException;
import java.util.logging.*;

public class TranslationLogger {

	private final static Logger LOGGER = Logger.getLogger(TranslationLogger.class.getName());

	public TranslationLogger() {
		try {
			FileHandler fileHandler = new FileHandler("logger.log", true);
			fileHandler.setFormatter(new SimpleFormatter());
			LOGGER.addHandler(fileHandler);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void log(String msg) {
		LOGGER.log(Level.WARNING, msg);
	}
}
