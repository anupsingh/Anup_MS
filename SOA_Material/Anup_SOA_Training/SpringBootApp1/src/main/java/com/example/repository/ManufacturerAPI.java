package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Manufacturer;

@RestController
public class ManufacturerAPI {

	@Autowired
	private ManufacturerRepository manufacturerRepository;

	@RequestMapping(value = "api/manufacturer")
	public ResponseEntity<Manufacturer> add(Manufacturer manufacturer) {
		return new ResponseEntity<Manufacturer>(manufacturerRepository.save(manufacturer), HttpStatus.CREATED);
	}

}
