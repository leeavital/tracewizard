package com.leeavital.a;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;

@Path("/")
public class ResourceB {
	
	@GET
	@Path("resource")
	@Produces(MediaType.APPLICATION_JSON)
	public String getResource(@HeaderParam("X-TraceId") String id) throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("b: " + id);
		return "{\"service\": \"b\"}";
	}
}
