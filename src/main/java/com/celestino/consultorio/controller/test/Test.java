package com.celestino.consultorio.controller.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Test {
	
	@GetMapping  //EndPoint
	public String test() {
		return "A API REST ESTÁ FUNCIONANDO!";
	}

}
