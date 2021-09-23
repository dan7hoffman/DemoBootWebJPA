package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.model.Blog;

@Service
public class BlogServiceImpl implements BlogService{

	List<Blog> al = new ArrayList<Blog>();
	
	public Blog saveBlog(Blog blog) {
		al.add(blog);
		return blog;
	}
	public List<Blog> getAllBlogs(){
		return al;
	}
	public Blog getBlogbyId(int id) {
		for(Blog bid:al) {
			if(bid.getBlogId()==id) {
				return bid;
			}
		}return null;
	}
	public Blog deleteBlog(int id) {
		for(Blog bid:al) {
			if(bid.getBlogId()==id) {
				al.remove(bid);
				return bid;
			}
		}return null;
	}
	public Blog updateBlog(Blog blog) {
		for(Blog bid:al) {
			if(bid.getBlogId()==blog.getBlogId()) {
				al.remove(bid);
				al.add(blog);
				return bid;
			}
		}return null;
	}
	@Override
	public Blog getBlogById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}

