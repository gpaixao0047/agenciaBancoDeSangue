package br.com.front.feign;

import feign.Feign;
import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;

public class FeignBuilder {
	private static final String CORE_URL = "http://localhost:8070/api";
	
	public static <T> T getInstanceWithTokenAcess(Class<T> clazz) {
		return Feign.builder().encoder(new JacksonEncoder()).decoder(new JacksonDecoder())
				.logger(new Slf4jLogger(clazz)).logLevel(Logger.Level.HEADERS)
				.requestInterceptor(new BasicAuthRequestInterceptor("gpaixao", "123456"))
				.target(new CustomTargetFeign<T>(clazz, CORE_URL));
	}
}
