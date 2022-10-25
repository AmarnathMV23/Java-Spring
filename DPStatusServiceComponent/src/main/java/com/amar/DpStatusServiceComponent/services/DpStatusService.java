package com.amar.DpStatusServiceComponent.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amar.DpStatusServiceComponent.entities.DpStatusEntity;
import com.amar.DpStatusServiceComponent.repo.DpStatusRepository;

import org.json.JSONException;
import org.json.JSONObject;

@Service
public class DpStatusService {

	@Autowired
	DpStatusRepository dpStatusRepository;

	public DpStatusEntity initDpStatusEntity(String dpStatusEntityAsStringMessage) {
		
		try {
		     JSONObject jsonObject = new JSONObject(dpStatusEntityAsStringMessage);
		     
	
		    	 DpStatusEntity dpStatusEntity = new DpStatusEntity(Integer.parseInt(jsonObject.get("dpId").toString()),false);
		    		DpStatusEntity savedDp =dpStatusRepository.save( dpStatusEntity);
		    		return savedDp;
		     
		}catch(JSONException err){
		
		}
	
		return null;
}

}
