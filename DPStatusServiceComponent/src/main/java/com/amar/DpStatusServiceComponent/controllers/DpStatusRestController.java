package com.amar.DpStatusServiceComponent.controllers;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.amar.DpStatusServiceComponent.services.DpStatusService;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;



@RestController
public class DpStatusRestController {


	
	@Autowired	
	DpStatusService dpStatusService;
	private final static String QUEUE_NAME = "dp_details";
	
	
	@GetMapping("/ts")
	public String getIndexPage() {
		
		return "Delivery Partner Status Service is up and running";
		
	}
	
  /*	@GetMapping("")
	public String getAllDpLoaded() {
		
		return "Delivery Partner Status Service is up and running";
		
	}
	*/
	//http://localhost:7070/dpstatusservice/
	@GetMapping("")
	public String testBehaviour() throws IOException, TimeoutException {
		

		
		 ConnectionFactory factory = new ConnectionFactory();
	      factory.setHost("localhost");
	      Connection connection = factory.newConnection();
	      Channel channel = connection.createChannel();
		  channel.queueDeclare(QUEUE_NAME, false, false, false, null);
	      DeliverCallback deliverCallback = (consumerTag, delivery) -> {
	          String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
	          System.out.println(" [x] Received '" + message + "'");
	          dpStatusService.initDpStatusEntity(message);
	          
	          
	      };
	      return channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
	}
}
