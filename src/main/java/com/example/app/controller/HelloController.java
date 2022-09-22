package com.example.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;

@RestController
public class HelloController {
	@GetMapping("/hello")
	@ResponseBody
	public String sayHello() {
		return "hello";
	}
	@GetMapping("/hello/ja")
	public String sayHelloJa() {
		return "<h1>こんにちは</h1>";
	}
	@GetMapping("/hello/many")
	public String[] sayHelloes() {
		String[] helloes = {
			"Hello",
			"こんにちは",
			"Aloha",
		};
		return helloes;
	}
	@GetMapping("/hello/json")
	public String sayHelloJson() {
		// {"en" : "hello", "ja" : "こんにちは"}
		return "{\"en\" : \"hello\", \"ja\" : \"こんにちは\"}";
	}
	@GetMapping("/hello/map")
	public Map<String,String> sayHelloMap() {
		Map<String,String> map = new HashMap<>();
		map.put("en", "hello");
		map.put("ja", "こんにちは");
		map.put("it", "Ciao");
		return map;
	}
	@GetMapping("/hello/list")
	public List<Hello> sayHelloList() {
		List<Hello> list = new ArrayList<>();
		list.add(new Hello("en", "Hello"));
		list.add(new Hello("ja", "こんにちは"));
		list.add(new Hello("it", "Ciao"));
		return list;
	}
}

@AllArgsConstructor
@Data
class Hello {
	private String country;
	private String greeting;
}
