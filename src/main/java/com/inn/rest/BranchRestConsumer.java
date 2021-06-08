package com.inn.rest;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BranchRestConsumer {

	@Autowired
	private LoadBalancerClient client;
	
	public String getmsg() {
		ServiceInstance si=client.choose("producer-app");
		URI uri = si.getUri();
		String url = uri + "/producer/getmsg";
		RestTemplate rt = new RestTemplate();
		ResponseEntity<String> resp = rt.getForEntity(url,
		String.class);
		return resp.getBody();
	}
}
