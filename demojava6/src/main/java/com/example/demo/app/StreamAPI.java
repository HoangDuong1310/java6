package com.example.demo.app;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.example.bean.Student;

public class StreamAPI {
	static List<Student> list = Arrays.asList(new Student("Nguyen Van Tèo", true, 7.5),
			new Student("Tran Thi Thu Huong", false, 5.5), 
			new Student("Pham Duc Cuòng", true, 9.5),
			new Student("Le Thi My Höng", false, 6.5), 
			new Student("Doàn Thi Kim Ty", false, 8.0)
	);

	public static void main(String[] args) {
//		demo1();
//		demo2();
//		demo3();
		demo4();
	}

	private static void demo4() {
	}

	private static void demo3() {
List<Student> result = list.stream()
.filter(sv -> sv.getMark() >=7)
.peek(sv -> sv.setName(sv.getName().toUpperCase()))
.collect(Collectors.toList());

result.forEach(sv -> {
	System.out.println("name" + sv.getName());
	System.out.println("mark" + sv.getMark());
	System.out.println();
});
	}

	private static void demo2() {
		List<Integer> list = Arrays.asList(1, 9, 4, 7, 5, 2);
		List<Double> result = list.stream().filter(n -> n % 2 == 0).map(n -> Math.sqrt(n))
				.peek(d -> System.out.println(d)).collect(Collectors.toList());
	}

	private static void demo1() {
		Stream<Integer> stream1 = Stream.of(1, 2, 4, 5, 4, 7);
		stream1.forEach(n -> {
			System.out.println(n);
		});

		List<Integer> list = Arrays.asList(1, 9, 4, 7, 5, 2);
		// Stream <Integer> stream2 = list.stream(;
		list.stream().forEach(n -> {
			System.out.println(n);
		});

	}

}
