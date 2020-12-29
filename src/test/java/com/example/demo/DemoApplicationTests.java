package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DemoApplicationTests {
	
	//regular jnuits didn't work for testing 
	// after excluding junit-vintage-engine and changing imports from org.junit.test to other junit imports autowired word
	// why the difference?
	
	@LocalServerPort
	public int port;
	
	@Autowired
	public SpringFoxController controller;
	
	@Autowired
	public TestRestTemplate testRestTemplate;

	@Test
	public void contextLoads() throws Exception{
		assertThat(controller).isNotNull();
		System.out.println(controller.getClass());
	}
	
	@Test
	public void greetingsTestClass() {
		assertThat(this.testRestTemplate.getForObject("http://localhost:"+port+"/display/raj", String.class).contains("raj"));
	}
	

}
