package com.soni.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.soni.messenger.datasource.InMemoryDataSource;
import com.soni.messenger.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages = InMemoryDataSource.getMessages();
	
	public MessageService() {
		messages.put(1L, new Message(1L, "msg1", "Sunny"));
		messages.put(2L, new Message(2L, "msg2", "Abhi"));
	}
	
	public List<Message> getMessages() {
		return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessage(long id) {
		return messages.get(id);
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id) {
		Message message = messages.get(id);
		messages.remove(id);
		return message;
	}
	
}
