package org.bhawna.restfulDemo.MessangerAPI.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.bhawna.restfulDemo.MessangerAPI.Model.Messages;
import org.bhawna.restfulDemo.MessangerAPI.database.Database;

public class MessageService {
	
	private static long num=1L;
	private static Map<Long,Messages> storeMessage = Database.getStoreMessages();
	
	public List<Messages> getMessages(){
		
		Messages message1 = new Messages(1L,"Hello Avinash","Bhawna");
		Messages message2 = new Messages(2L,"Hello Bhawna","Bhawna");
		Messages message3 = new Messages(3L,"Hello Koushik","Bhawna");
		
		List<Messages> messageList = new ArrayList<Messages>();
		messageList.add(message1);
		messageList.add(message2);
		messageList.add(message3);
		
		return messageList;
	}
	
	public List<Messages> getAllMessages(){
		
		return new ArrayList<Messages>(storeMessage.values());
		
	}
	
	public Messages getMessage(long messageID){
		
		return storeMessage.get(messageID);
	}
	
	public List<Messages> getAllMessagesForUser(int year){
		
		List<Messages> messagesForUser = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for(Messages message: storeMessage.values()){
			cal.setTime(message.getDateCreated());
			if(cal.get(Calendar.YEAR)==year){
				messagesForUser.add(message);
			}
		}
		
		return messagesForUser;
	}
	
	public Messages addMessage(Messages messages){
		messages.setId(num++);
        storeMessage.put(messages.getId(), messages);			
			return messages;
		}
	
	public Messages updateMessage(Messages message){
		
		if(message.getId() <=0){
			return null;
		}
		storeMessage.put(message.getId(), message);
		
		return message;
	}
	
	public Messages removeMessage(long id){
		
		return storeMessage.remove(id);
	}
}
