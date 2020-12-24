package com.maduranga;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Blogs", catalog="restapi", schema="dbo")
public class Blog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BlogId", nullable = false)
	private int id;

	@Column(name = "Title")
	private String title;

	@Column(name = "content")
	private String content;
	
	@Column(name = "UserId")
	private int uid;

	public Blog() {

	}

	public Blog(Integer userid, String title, String content) {
		this.setUid(userid);
		this.setTitle(title);
		this.setContent(content);
	}

	public Blog(int id, String title, String content, int userid) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.uid = userid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", content=" + content + ", uid=" + uid + "]";
	}

	

}
