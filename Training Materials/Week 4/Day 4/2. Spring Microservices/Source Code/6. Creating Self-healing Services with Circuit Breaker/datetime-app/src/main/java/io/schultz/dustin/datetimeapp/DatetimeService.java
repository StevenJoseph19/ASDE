package io.schultz.dustin.datetimeapp;

import org.springframework.beans.factory.annotation.Autowired;

//import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class DatetimeService {

//	@Inject
	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "unknown")
	public String getCurrentDatetime() {
		return restTemplate.getForEntity("http://datetime-service/datetime", String.class).getBody();
	}

	public String unknown() {
		return "unknown";
	}
}
