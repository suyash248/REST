package com.soni.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.soni.messenger.model.Comment;
import com.soni.messenger.service.CommentService;

@Path(value="/")
@Produces(value=MediaType.APPLICATION_JSON)
@Consumes(value=MediaType.APPLICATION_JSON)
public class CommentResource {

CommentService commentService = new CommentService();
	@GET
	public List<Comment> getComments( @PathParam("messageId") long messageId){
		return commentService.getComments(messageId);
	}
	
	@POST
	public Comment addComment(@PathParam("messageId") long messageId, Comment comment){
		return commentService.addComment(messageId, comment);
	}
	
	@GET
	@Path(value="/{commentId}")
	public Comment getComment(@PathParam("messageId") long messageId, @PathParam(value="commentId") long commentId) {
		return commentService.getComment(messageId, commentId);
	}
	
	@PUT
	@Path(value="/{commentId}")
	public Comment updateComment(@PathParam("messageId") long messageId, @PathParam(value="commentId") long commentId, Comment comment) {
		comment.setId(commentId);
		return commentService.updateComment(messageId, comment);
	}

	@DELETE
	@Path(value="/{commentId}")
	public void removeComment(@PathParam("messageId") long messageId, @PathParam(value="commentId") long commentId) {
		commentService.removeComment(messageId, commentId);
	}
}
