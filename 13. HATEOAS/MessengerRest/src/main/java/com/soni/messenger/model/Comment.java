package com.soni.messenger.model;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Comment {
	
	public Comment(long id, String content, String author){
		this.id = id;
		this.created = new Date();
		this.content = content;
		this.author = author;
	}
	
	private long id;
	private String content;
	private Date created;
	private String author;
}
