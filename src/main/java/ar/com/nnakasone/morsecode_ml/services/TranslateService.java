package ar.com.nnakasone.morsecode_ml.services;

import org.springframework.stereotype.Service;

import ar.com.nnakasone.morsecode_ml.exception.UnknownCodeException;

/**
 * @author Nicolas Nakasone
 *
 */

@Service
public interface TranslateService {
	public String translate() throws UnknownCodeException;
}
 