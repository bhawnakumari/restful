package org.bhawna.restfulWebServices.MessangerAPI.messanger.resources;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.bhawna.restfulDemo.MessangerAPI.Model.Messages;
import org.bhawna.restfulDemo.MessangerAPI.services.MessageService;

@Path("/messages")

public class MessageResource {
	
	private MessageService messageService = new MessageService();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Messages> getMessages(){
		
		return messageService.getMessages();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{messageID}")
	public Messages getMessageById(@PathParam("messageID") long messageID){
		
	return	messageService.getMessage(messageID);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/All")
	public List<Messages> getAllMessages(){
		
	return	messageService.getAllMessages();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/All/user")
	public List<Messages> getAllMessagesForUser(@QueryParam("year") int year){
		
	return	messageService.getAllMessagesForUser(year);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addMessages")
	public Messages postMessage(Messages messages){
		messageService.addMessage(messages);
		
		return messages;
	}
	
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/updateMessages/{messageID}")
    public Messages updateMessage(@PathParam("messageID")long messageID , Messages messages){
    	messages.setId(messageID);
    	return messageService.updateMessage(messages);
    }
}
