package com.zensar.endpoints;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Endpoint(id="myendpoint")
@Component
public class MyEndpoint {
	
	@ReadOperation
	public String myEndPoint() {
		return "testing";
	}
	
	
	

}
