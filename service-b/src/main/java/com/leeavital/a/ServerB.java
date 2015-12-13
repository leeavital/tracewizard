package com.leeavital.a;

import com.leeavital.tracewizard.TracingFilter;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;


public class ServerB extends Application<Configuration> {

  public static void main(String[] args) throws Exception {
      new ServerB().run(args);
  }

  @Override
  public void run(Configuration configuration, Environment environment)
		  throws Exception {
	  environment.jersey().register(new TracingFilter());
	  environment.jersey().register(ResourceB.class);

  }
}
