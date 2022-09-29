package com.example.lesson05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/lesson05")
@Controller
public class Lesson05Controller {
	
	@RequestMapping("/ex01")
	public String ex01() {
		return "lesson05/ex01";
	}
	
	@RequestMapping("ex02")
	public String ex02(Model model) {
		// list<String>
		List<String> fruits = new ArrayList<>();
		fruits.add("apple");
		fruits.add("melon");
		fruits.add("peach");
		fruits.add("grape");
		fruits.add("mango");
		
		model.addAttribute("fruits", fruits);
		
		//List<Map>
		List<Map<String, Object>> users = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		map.put("name", "김태진");
		map.put("age", 23);
		map.put("hobby", "책읽기");
		users.add(map);
		map = new HashMap<>();
		map.put("name", "이성현");
		map.put("age", 22);
		map.put("hobby", "영화보기");
		users.add(map);
		
		model.addAttribute("users", users);
		return "lesson05/ex02";
	}
}
