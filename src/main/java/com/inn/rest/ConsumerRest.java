package com.inn.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class ConsumerRest {

	@Autowired
	private BranchRestConsumer consumer;
	
	@GetMapping("/getmsg")
	public ResponseEntity<String> getmsg(){
		return ResponseEntity.ok(consumer.getmsg());
	}
}
