package com.leeavital.a;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import feign.RequestLine;

public interface ServiceB {
	@RequestLine("GET /resource")
	String getResource();
}
