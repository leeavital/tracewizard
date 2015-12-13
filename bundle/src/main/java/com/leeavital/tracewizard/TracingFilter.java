package com.leeavital.tracewizard;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;

public class TracingFilter implements ContainerRequestFilter {

	public void filter(ContainerRequestContext requestContext)
			throws IOException {
	
		List<String> ids = requestContext.getHeaders().get(TraceIdUtils.TRACE_SPAN_KEY);
		
		
		if (ids == null || ids.size() == 0) {
			System.out.println("new tracespace: " + TraceIdUtils.traceId.get());
		} else if (ids.size() == 1) {
			System.out.println("tracespan " + TraceIdUtils.traceId.get() + " is a child of " + ids.get(0));
		} else {
			throw new RuntimeException("too many trace ids");
		}
	}
}
