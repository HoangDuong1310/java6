package com.example.demo.app;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Jackson1 {

	public static void main(String[] args) throws Exception {
//		demo1();
		demo2();
	}

	private static void demo2() throws IOException {
		String path = "C:\\Users\\Duong\\eclipse-workspace\\demojava6\\src\\main\\resources\\students.json";	
		ObjectMapper mapper = new ObjectMapper();
		JsonNode students = mapper.readTree(new File(path));
		students.iterator().forEachRemaining(student -> {
			System.err.println("name : " + student.get("name").asText());
		});
	}

	private static void demo1() throws Exception {
		String path = "C:\\Users\\Duong\\eclipse-workspace\\demojava6\\src\\main\\resources\\student.json";

		ObjectMapper mapper = new ObjectMapper();
		JsonNode student = mapper.readTree(new File(path));
		System.out.println("name : " + student.get("name").asText());
		System.out.println("mark : " + student.get("mark").asDouble());
		System.out.println("gender : " + student.get("gender").asBoolean());
		System.out.println("email" + student.get("contact").get("email").asText());
		System.out.println("phone" + student.get("contact").get("phone").asText());
		student.get("subject").iterator().forEachRemaining(subject -> {
			System.out.println("subject" + subject.asText());
		});
	}

}
