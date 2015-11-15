package com.soni.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlRootElement
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Message {
	private long id;
	private String message;
	private Date created;
	private String author;
}
