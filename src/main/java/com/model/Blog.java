package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity //will turn the User class into a table
public class Blog {
	@Id //Will turn name into the primary key
	private int blogId;
	private String blogTitle;
	private String authorName;
	private String blogContents;
	public Blog(int blogId, String blogTitle, String authorName, String blogContents) {
		super();
		this.blogId = blogId;
		this.blogTitle = blogTitle;
		this.authorName = authorName;
		this.blogContents = blogContents;
	}
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	public String getBlogTitle() {
		return blogTitle;
	}
	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getblogContents() {
		return blogContents;
	}
	public void setblogContents(String blogContents) {
		this.blogContents = blogContents;
	}
	@Override
	public String toString() {
		return "Blog [blogId=" + blogId + ", blogTitle=" + blogTitle + ", authorName=" + authorName + ", blogContents="
				+ blogContents + "]";
	}

}
