package com.example.lesson06;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.bo.UserBO;

@RequestMapping("/lesson06")
@Controller
public class Lesson06Controller {
	
	@Autowired
	private UserBO userBO;
	
	@RequestMapping("/ex01/add_user_view")
	public String addUserView() {
		return "lesson06/addUser";
	}
	
	@ResponseBody
	@PostMapping("/ex01/add_user")
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam("email") String email,
			@RequestParam(value="introduce", required=false) String introduce) {
		
		userBO.addUser(name, yyyymmdd, email, introduce);
		
		return "success";
	}
	
	// ex02
	@RequestMapping("/ex02/add_name_view")
	public String addNameView() {
		return "lesson06/addName";
	}
	
	// JSON String 
	@ResponseBody
	@GetMapping("/ex02/is_duplication")
	public Map<String, Boolean> isDuplication(
			@RequestParam("name") String name) {
		
		Map<String, Boolean> result = new HashMap<>();
		boolean isDuplication = userBO.existUserByName(name);
		result.put("is_duplication", isDuplication);
		
		return result;
	}
}
