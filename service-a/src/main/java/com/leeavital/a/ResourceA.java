package com.leeavital.a;

import java.io.IOException;
import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.common.collect.ImmutableList;
import com.leeavital.tracewizard.TraceInjector;

import feign.Client;
import feign.Feign;
import feign.Request;
import feign.RequestInterceptor;
import feign.Request.Options;
import feign.RequestTemplate;
import feign.Response;
import feign.okhttp.OkHttpClient;

@Path("/")
public class ResourceA {

  ServiceB service;

	public ResourceA() {
		service = Feign
			.builder()
			.requestInterceptor(new TraceInjector())
			.client(new OkHttpClient())
			.target(ServiceB.class, "http://localhost:7070");
	}

	@GET
	@Path("resource")
	@Produces(MediaType.APPLICATION_JSON)
	public String getResource() throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("remoted : " + service.getResource());
		return "{\"service\": \"a\"}";
	}
}
