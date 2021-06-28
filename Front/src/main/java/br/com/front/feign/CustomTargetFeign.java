package br.com.front.feign;

import feign.Request;
import feign.RequestTemplate;
import feign.Target;

public class CustomTargetFeign <T> implements Target<T> {
	
	private final Class<T> type;
	private final String url;
	private final String name;
	
	public CustomTargetFeign(Class<T> type, String url) {
		this(type,url,url);
	}

	private CustomTargetFeign(Class<T> type, String url, String name) {
	this.type = type;
	this.url = url;
	this.name = name;
	}

	@Override
	public Class<T> type() {
		return type;
	}

	@Override
	public String name() {
		return name;
	}

	@Override
	public String url() {
		return url;
	}

	@Override
	public Request apply(RequestTemplate input) {
		if(input.url().indexOf("http") != 0) {
			input.insert(0, url());
		}
		input.header("Content-Type", "application/json");
		return input.request();
	}
	
	
}
