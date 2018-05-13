package org.bhawna.restfulDemo.MessangerAPI.database;

import java.util.HashMap;
import java.util.Map;

import org.bhawna.restfulDemo.MessangerAPI.Model.Messages;

public class Database {
	
	private static Map<Long,Messages> storeMessages = new HashMap<>();
	

	public static Map<Long, Messages> getStoreMessages() {
		return storeMessages;
	}
	
}
