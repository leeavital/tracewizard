package com.leeavital.tracewizard;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class TraceInjector implements RequestInterceptor {
	
	@Override
	public void apply(RequestTemplate template) {
		template.header(TraceIdUtils.TRACE_SPAN_KEY, TraceIdUtils.traceId.get().toString());	
	}
}