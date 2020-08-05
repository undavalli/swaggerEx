package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringFoxController {
	
	@GetMapping(path="/display/{name}")
	public String display(@PathVariable("name") String name) {
		System.out.println("name="+name);
		return name;
		
	}

}
