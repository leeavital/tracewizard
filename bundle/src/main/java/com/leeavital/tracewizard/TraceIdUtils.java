package com.leeavital.tracewizard;

import java.util.UUID;

public class TraceIdUtils {

	public static final String TRACE_SPAN_KEY = "X-TraceSpan-Id";
	
	static ThreadLocal<UUID> traceId = new ThreadLocal<UUID>() {
		 @Override
		 protected UUID initialValue() {
            return UUID.randomUUID();
		 }
	};
}
