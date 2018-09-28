package com.revature.eval.java.core;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.controllers.UserSettingsController;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserTesting {
	@LocalServerPort
	private int port;
	
	@Autowired
	UserSettingsController uc;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void returnUser() {
		assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/users", List.class)).isInstanceOf(List.class);
//																				.isInstanceOf(object);
	}
	
	
}
