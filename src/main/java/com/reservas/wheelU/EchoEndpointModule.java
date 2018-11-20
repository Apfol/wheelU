package com.reservas.wheelU;

import com.google.api.server.spi.guice.EndpointsModule;


import com.google.api.control.ServiceManagementConfigFilter;
import com.google.api.control.extensions.appengine.GoogleAppEngineControlFilter;
import com.google.common.collect.ImmutableList;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Singleton;

public class EchoEndpointModule extends EndpointsModule {

	@Override
	  public void configureServlets() {
	    super.configureServlets();

	    bind(ServiceManagementConfigFilter.class).in(Singleton.class);
	    filter("/_ah/api/*").through(ServiceManagementConfigFilter.class);

	    Map<String, String> apiController = new HashMap<String, String>();
	    apiController.put("endpoints.projectId", "wheel-u-reservas");
	    apiController.put("endpoints.serviceName", "wheel-u-reservas.appspot.com");

	    bind(GoogleAppEngineControlFilter.class).in(Singleton.class);
	    filter("/_ah/api/*").through(GoogleAppEngineControlFilter.class, apiController);

	    bind(YourFirstAPI.class).toInstance(new YourFirstAPI());
	    configureEndpoints("/_ah/api/*", ImmutableList.of(YourFirstAPI.class));
	  }

}
