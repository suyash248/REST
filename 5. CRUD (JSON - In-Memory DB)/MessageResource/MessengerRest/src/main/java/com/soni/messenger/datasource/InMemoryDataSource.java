package com.soni.messenger.datasource;

import java.util.HashMap;
import java.util.Map;

import com.soni.messenger.model.Message;

public class InMemoryDataSource {
	private static Map<Long, Message> messages = new HashMap<Long, Message>();
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
}
