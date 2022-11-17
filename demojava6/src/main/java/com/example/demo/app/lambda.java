package com.example.demo.app;

import java.util.Arrays;
import java.util.List;

public class lambda {

	public static void main(String[] args) {
		demo1();
		demo2();
	}

	private static void demo2() {
		
	}

	private static void demo1() {
		List<Integer> list = Arrays.asList(1, 3, 4, 6, 7, 4, 7);
		list.forEach(n -> System.out.println(n));
	}

}
