package com.amar.DPServiceComponent.services;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amar.DPServiceComponent.entity.DpEntity;
import com.amar.DPServiceComponent.repo.DpRepository;

@Service 
public class DpService {

	
	@Autowired
	DpRepository dpRepo;

	public DpEntity addDp(DpEntity dpEntity) {
				
		DpEntity savedDpEntity = dpRepo.save(dpEntity);		
		return savedDpEntity;
				
	}
	
	public List<DpEntity> getAllDP() {
		
		Iterable<DpEntity> savedDpEntity = dpRepo.findAll();	
		List<DpEntity> newSet= new ArrayList<DpEntity>();
		savedDpEntity.forEach(e -> {
			newSet.add(e);
			
		});
		return newSet;
				
	}
}
