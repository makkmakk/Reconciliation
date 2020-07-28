package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Premium;
import com.model.PremiumRepository;

@RestController
@RequestMapping("/premium")
public class PremiumRestController {
	
	@Autowired
	PremiumRepository repository;
	
	public Iterable<Premium> getDetails(){
		return repository.findAll();
	}

}
