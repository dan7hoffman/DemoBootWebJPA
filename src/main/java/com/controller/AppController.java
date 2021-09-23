package com.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.model.Blog;
import com.model.User;
import com.service.BlogServiceImpl;
import com.service.UserService;

@RestController
@RequestMapping("/mainapp")
public class AppController {

	@Autowired
	private UserService service;
	@Autowired
	private BlogServiceImpl blogService;

//	//WELCOME PAGE
//	@RequestMapping(value = "/welcome",method = RequestMethod.GET)
//	@ResponseBody
//	public String sayWelcome() {
//		
//		return "welcome to my app";
//	}

	// LOGIN PAGE
	// LOGIN GET
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	// LOGIN POST
	// Checks against the UserService.java
	@PostMapping("/login")
	// @ResponseBody
	public String loginValid(@RequestParam("uname") String name, @RequestParam("password") String password) {

		User user = new User(name, password);
		if (service.userValidation(user)) {
			return "user login successfull";
		}
		return "login failed";
	}

	// REGISTRATION PAGE
	// REGISTRATION GET
	@GetMapping("/registration")
	@ResponseBody
	public String registration() {
		return "registration";
	}

	// REGISTRATION POST
	// Checks against the UserService.java
	@PostMapping("/registration")
	// @ResponseBody
	public String userregister(@RequestBody User user) {
		service.userRegistration(user);
		return "user added";

	}

	// Load All Users
	@GetMapping("/loadall")
	public List<User> loadAll() {
		return service.loadAll();
	}

	// Find a specific user
	@GetMapping("/finduser/{name}")
	public String findUser(@PathVariable("name") String name) {

		if (service.findUser(name)) {
			return "user found";
		}
		return "user not found";
	}

	@DeleteMapping("deleteuser/{name}")
	public String deleteUser(@PathVariable("name") String name) {
		service.deleteUser(name);
		return "User deleted";
	}
	
	//This will update a blog based on the id
	@PutMapping("/updateuser/{name}")
	public String updateUser(@RequestBody User user, @PathVariable("name")String name) {
		service.updateUser(name, user);
		return "User updated";
	}
	
	@PostMapping("/blogpost")
	public String postBlog(@RequestBody Blog blog) {
		blogService.saveBlog(blog);
		return "Blog Saved";
	}
	
	@GetMapping("/loadallblogs")
	public List<Blog> loadAllBlogs(){
		return blogService.getAllBlogs();
	}
	
	@GetMapping("/blogpost/{id}")
	public Blog getBlog(@PathVariable("id") int id) {
		return blogService.getBlogbyId(id);
	}
	
	@GetMapping("deleteblog/{id}")
	public String deleteBlog(@PathVariable("id") int id) {
		blogService.deleteBlog(id);
		return "Blog deleted";
	}
	
	@PutMapping("/updateblog/{id}")
	public String updateBlog(@RequestBody Blog blog, @PathVariable("id") int id) {
		blogService.updateBlog(blog);
		return "Blog Updated";
	}

}
