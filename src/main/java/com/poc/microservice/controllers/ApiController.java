package com.poc.microservice.controllers;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.poc.microservice.apis.DummyApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import com.poc.microservice.services.DummyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController implements DummyApi {

	Logger log = LoggerFactory.getLogger(ApiController.class);

	private final DummyService dummyService;

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	public ApiController(ObjectMapper objectMapper, HttpServletRequest request, DummyService dummyService) {
		this.objectMapper = objectMapper;
		this.request = request;
		this.dummyService = dummyService;
	}

	@Override
	public Optional<ObjectMapper> getObjectMapper() {
		return Optional.ofNullable(objectMapper);
	}

	@Override
	public Optional<HttpServletRequest> getRequest() {
		return Optional.ofNullable(request);
	}

	@Override
	@PreAuthorize("hasRole('CUSTOMER')")
	public ResponseEntity<?> getDummyById(String auth, Long id) {
		String response = dummyService.getDummyById(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}