package com.soni.messenger.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Message {
	
	public Message(long id, String message, String author){
		this.id = id;
		this.created = new Date();
		this.message = message;
		this.author = author;
	}
	
	private long id;
	private String message;
	private Date created;
	private String author;
	private Map<Long, Comment> comments = new HashMap<>();
}
