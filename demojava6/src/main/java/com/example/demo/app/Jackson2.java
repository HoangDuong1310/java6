package com.example.demo.app;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Jackson2 {

	public static void main(String[] args) throws IOException {
		demo1();
	}

	private static void demo1() throws IOException {
		String path = "C:\\Users\\Duong\\eclipse-workspace\\demojava6\\src\\main\\resources\\student.json";
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> student = mapper.readValue(new File(path), Map.class);
		System.out.println("name : " + student.get("name"));
		System.out.println("mark : " + student.get("mark"));
		System.out.println("gender : " + student.get("gender"));
		Map<String, Object> contact = (Map<String, Object>) student.get("contact");
		System.out.println("email" + contact.get("email"));
		System.out.println("phone" + contact.get("phone"));
		List<String> subjects = (List<String>) student.get("subject");
		subjects.forEach(subject -> {
			System.out.println("subject : " + subject);
		});
	}

}
