package com.soni.messenger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.soni.messenger.model.Message;

public class MessageService {
	public List<Message> getMessages() {
		List<Message> messages = new ArrayList<Message>();
		messages.add(new Message(1L, "msg1", new Date(), "Sunny"));
		messages.add(new Message(2L, "msg2", new Date(), "Suyash"));
		return messages;
	}
}
