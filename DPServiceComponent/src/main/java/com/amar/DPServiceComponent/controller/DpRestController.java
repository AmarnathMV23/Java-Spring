package com.amar.DPServiceComponent.controller;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amar.DPServiceComponent.entity.DpEntity;
import com.amar.DPServiceComponent.services.DpService;


@RestController
public class DpRestController {

	@Autowired
	DpService dpService;
	

	@GetMapping("")
	public String getIndexPage() {
		
		return "Delivery Partner Service is up and running";
		
	}
	
	
	@PostMapping("/addDp")
	//@Produces(MediaType.APPLICATION_JSON)
	public DpEntity addDpEntity(@RequestBody DpEntity dpEntity) {
		
		DpEntity savedDpEntity= dpService.addDp(dpEntity);
		
		return savedDpEntity;
		
		
	}
	
	@GetMapping("/getAllDp")
	public List<DpEntity> getAllDpEntity() {
		
		List<DpEntity> listDpEntity = dpService.getAllDP();
		return listDpEntity;		
		
	}

}
