package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AppDao;
import com.model.User;
@Service
public class UserService {
	
	@Autowired
	private AppDao appDao;
	List<User> al= new ArrayList<User>();
	
	public boolean userValidation(User user) {
		
		if(user.getName().equals("admin") && user.getPassword().equals("manager")) {
			return true;
		}
		return false;
	}
	
	//Register users using the appDao Save method
	
	public void userRegistration(User user) {
		//System.out.println(al);
		appDao.save(user);
		//al.add(user);
	}

	//Load all users using the appDao find method
	public List<User> loadAll() {
		List<User> al = (List<User>) appDao.findAll();
		return al;
	}
	
	//This is a method to get a blog by the ID number
	public boolean findUser(String user) {
		
		Optional<User> usr = appDao.findById(user);
		
		if(usr.isPresent()) {
			return true;
		}return false;
	}
		
	//This is a method to delete a blog
	public boolean deleteUser(String user) {
		Optional<User> usr = appDao.findById(user);
		if(usr.isPresent()) {
			appDao.deleteById(user);
			return true;
		}return false;
	}

	//This is a method to update the blog
	public boolean updateUser(String name,User user) {
		Optional<User> usr = appDao.findById(name);
		if(usr.isPresent()) {
			appDao.deleteById(name);
			appDao.save(user);
			//al.remove(usr);
			//al.add(user);
			return true;
		}return false;

	}
	
}



