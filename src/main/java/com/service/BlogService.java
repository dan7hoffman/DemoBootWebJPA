package com.service;

import java.util.List;
import com.model.Blog;

public interface BlogService {
	
	Blog saveBlog(Blog blog);
	
	List<Blog> getAllBlogs();
	
	Blog getBlogById(int id);
	
	Blog deleteBlog(int id);
	
	Blog updateBlog(Blog blog);

}