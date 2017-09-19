package com.example;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.example.model.Order;

public class ConsumerService {

	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping("/order")
	public List<Order> getData() {
		List<ServiceInstance> list = discoveryClient.getInstances("order-microservice");
		if (list != null && list.size() > 0) {
			URI uri = list.get(0).getUri();
			if (uri != null) {
				return (new RestTemplate()).getForObject(uri, List.class);
			}
		}
		return null;
	}

}
