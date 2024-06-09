package com.org.springboot002;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
	@RequestMapping("/msg")
	public String getMsg() {
		return "GOOD EVENING";
	}
	@GetMapping("/std")
	public Student getStudent() {
		Student s = new Student();
		s.setRoll(101);
		s.setName("abc");
		s.setAge(24);
		return s;
	}
	@RequestMapping("/stds")
	public List<Student> getStudents(){
		Student s1 = new Student();
		s1.setRoll(101);
		s1.setName("aaa");
		s1.setAge(24);
		
		Student s2 = new Student();
		s2.setRoll(102);
		s2.setName("bbb");
		s2.setAge(19);
		
		Student s3 = new Student();
		s3.setRoll(103);
		s3.setName("ccc");
		s3.setAge(20);
		
		List<Student> students = new ArrayList<>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		return students;
	}
	@PostMapping("/std")
	public String postStudent(@RequestBody Student s) {
		System.out.println(s.getRoll());
		System.out.println(s.getName());
		System.out.println(s.getAge());
		
		return "success";
	}
	
	@RequestMapping(value = "/test" , method = RequestMethod.GET )
	public String getQueryString(@RequestParam int roll) {
		return "ROLL is : "+roll;
	}
	
	@RequestMapping(value = "/test2" , method = RequestMethod.GET )
	public String getQueryString(@RequestParam int roll, @RequestParam String name) {
		return "ROLL is : "+roll+ " NAME is : "+name;
	}
	
	@RequestMapping("/test/{roll}/{name}")
	public String getPathVariable(@PathVariable int roll, @PathVariable String name) {
		return "ROLL is : "+roll+ " NAME is : "+name;
	}
	
	@RequestMapping("/test2/{roll}/{name}")
	public String getPVandQS(@PathVariable int roll, @PathVariable String name, @RequestParam int age) {
		return "ROLL is : "+roll+ " NAME is : "+name+ " AGE is : "+age;
	}
}
