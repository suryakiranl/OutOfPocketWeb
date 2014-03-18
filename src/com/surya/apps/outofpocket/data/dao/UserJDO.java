package com.surya.apps.outofpocket.data.dao;

import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.surya.apps.outofpocket.business.dto.UserDTO;
import com.surya.apps.outofpocket.common.util.Logger;

public class UserJDO {
	private static final Logger LOG = Logger.get();
	
	private static final String NAME = "name";
	private static final String EMAIL = "email";
	private static final String PASSWORD = "password";
	
	private Key getKey(String name) {
		Key key = KeyFactory.createKey("UserKey", name);
		
		return key;
	}
	
	public boolean save(UserDTO user) {
		if(user == null) {
			LOG.warn("Save method called with NULL object");
			return false;
		}
		
		Key userKey = getKey(user.getEmail());
		Entity userE = new Entity("User", userKey);
		userE.setProperty(NAME, user.getName());
		userE.setProperty(EMAIL, user.getEmail());
		userE.setProperty(PASSWORD, user.getPassword());
		
		DatastoreService dataStore = DatastoreServiceFactory.getDatastoreService();
		dataStore.put(userE);
		
		return true;
	}
	
	public List<UserDTO> findAll() {
		return null;
	}
}
