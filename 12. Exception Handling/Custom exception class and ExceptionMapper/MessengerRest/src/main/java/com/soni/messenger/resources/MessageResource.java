package com.soni.messenger.resources;

import java.net.URI;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.soni.messenger.exception.DataNotFoundException;
import com.soni.messenger.model.Message;
import com.soni.messenger.service.MessageService;

@Path(value="/messages")
@Produces(value=MediaType.APPLICATION_JSON)
@Consumes(value=MediaType.APPLICATION_JSON)
public class MessageResource {
	
	MessageService messageService = new MessageService();
	
	@GET
	public List<Message> getMessages( @QueryParam("author") String author,
																				@QueryParam("start") int start,
																				@QueryParam("size") int size) 
	{
		if(author!=null && !author.isEmpty()) 
			return messageService.getMessagesByAuthor(author);
		if(start>0 && size>0) 
			return messageService.getMessagesPaginated(start, size);
		return messageService.getMessages();
	}
	
	@GET
	@Path(value="/{msgId}")
	public Message getMessage(@PathParam(value="msgId") long id) {
		Message message = messageService.getMessage(id);
		if(message==null)
			throw new DataNotFoundException("Message with id : "+ id + " not found.");
		return message;
	}
	
	@POST
	public Response addMessage(Message message, @Context UriInfo uriInfo) {
		Message newMsg = messageService.addMessage(message);
		URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(newMsg.getId())).build();
		Response response = Response
				.created(uri)								// <--- This created(URI uri) method will send status code=201 & Location header = uri
				.entity(newMsg)
				.build();
		return response;
	}
	
	@PUT
	@Path(value="/{msgId}")
	public Message updateMessage(Message message, @PathParam(value="msgId") long id) {
		message.setId(id);
		return messageService.updateMessage(message);
	}

	@DELETE
	@Path(value="/{msgId}")
	public Message removeMessage(@PathParam(value="msgId") long id) {
		return messageService.removeMessage(id);
	}
	
	/************** Sub resource ***************/
	@Path(value="/{messageId}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
	}
}
