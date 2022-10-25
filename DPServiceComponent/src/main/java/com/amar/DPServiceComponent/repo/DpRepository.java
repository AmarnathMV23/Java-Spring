package com.amar.DPServiceComponent.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amar.DPServiceComponent.entity.DpEntity;

@Repository
public interface DpRepository extends CrudRepository<DpEntity, Integer>{

}
