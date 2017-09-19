package com.example;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MyResource {

	@RequestMapping(value = "/", produces=MediaType.TEXT_PLAIN_VALUE)
	public String getData() {
		return "hello";
	}
}
