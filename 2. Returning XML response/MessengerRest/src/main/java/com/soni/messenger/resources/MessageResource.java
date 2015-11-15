package com.soni.messenger.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.soni.messenger.model.Message;
import com.soni.messenger.service.MessageService;

@Path(value="/messages")
public class MessageResource {

	MessageService messageService = new MessageService();
	
	@GET
	@Produces(value=MediaType.APPLICATION_XML)
	public List<Message> getMessages() {
		return messageService.getMessages();
	}
}
