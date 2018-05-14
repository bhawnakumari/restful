package org.bhawna.restfulWebServices.MessangerAPI.messanger.resources;

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
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.bhawna.restfulDemo.MessangerAPI.Model.Messages;
import org.bhawna.restfulDemo.MessangerAPI.services.DataNotFoundException;
import org.bhawna.restfulDemo.MessangerAPI.services.MessageService;

@Path("/messages")

public class MessageResource {
	
	private MessageService messageService = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Messages> getMessages(){
		
		return messageService.getMessages();
	}
	
	/**
	 * get message details as per ID
	 * @param messageID
	 * @return message for this ID
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{messageID}")
	public Messages getMessageById(@PathParam("messageID") long messageID){
		
	return	messageService.getMessage(messageID);
	}
	
	/**
	 * get all the messages
	 * @return whole message list
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/All")
	public List<Messages> getAllMessages(){
		
	return	messageService.getAllMessages();
	}
	
	/**
	 * demo for filtering data
	 * @param year
	 * @return message for particular year
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/All/user")
	public List<Messages> getAllMessagesForUser(@QueryParam("year") int year){
		
	return	messageService.getAllMessagesForUser(year);
	}
	
	/**
	 * to create data
	 * @param messages
	 * @return message list
	 */
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
    
    @DELETE
    @Path("/delete/{messageID}")
    public Messages deleteMessages(@PathParam("messageID") long messageID){
    	return messageService.removeMessage(messageID);
    }
    
    
    /**
     * create a status code
     * @param messages
     * @return response
     */
    @POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/createMessages")
	public Response createMessage(Messages messages){
    	
    return Response.status(Status.CREATED).
    	entity(messageService.addMessage(messages)).build();
	}
    
    @POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/URIPassed")
	public Response createMessageWithURI(@Context UriInfo UriInfo , Messages messages){
    
    	Messages newMessage = messageService.addMessage(messages);
    	String messageID = String.valueOf(newMessage.getId());
    	
    	System.out.println(UriInfo.getPath());
    	
    	URI url = UriInfo.getAbsolutePathBuilder(). //build();
    	path(messageID).build();
    	
    return Response.created(url).build();
	}
    
    /**
	 * get message details as per ID
	 * @param messageID
	 * @return message for this ID
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{messageID}/exception")
	public Messages getMessageByIdWithException(@PathParam("messageID") long messageID){
		
	Messages message =	messageService.getMessage(messageID);
	if(message == null){
		throw new DataNotFoundException("Data not found : "+ messageID);
		
	}
	return message;
	}
}
