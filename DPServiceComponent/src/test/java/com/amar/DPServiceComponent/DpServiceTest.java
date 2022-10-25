package com.amar.DPServiceComponent;

import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.amar.DPServiceComponent.entity.DpEntity;
import com.amar.DPServiceComponent.repo.DpRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class DpServiceTest {

	
	 private final static String QUEUE_NAME = "dp_details";
	@Autowired
	private DpRepository userRepo;

	@Test
	public void testCreateUser() {
		
		DpEntity dpEntity = new DpEntity("DP1");
		userRepo.save(dpEntity);
	
	}
	
	@Test
	public void testCreateUserAndPublish() {
		
		DpEntity dpEntity = new DpEntity("DP14");
		DpEntity savedDpEntity=userRepo.save(dpEntity);
			
	ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    try {
    	Connection connection = factory.newConnection();   
         Channel channel = connection.createChannel(); 
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        ObjectMapper mapper = new ObjectMapper();
        String test=mapper.writeValueAsString(savedDpEntity);
        channel.basicPublish("", QUEUE_NAME, null, test.getBytes(StandardCharsets.UTF_8));
        
    }
     catch(Exception e) {
    	 
     }   
    
	}
	
}
