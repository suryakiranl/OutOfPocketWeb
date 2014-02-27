package com.surya.apps.outofpocket.dao;

import java.util.List;
import java.util.logging.Logger;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.surya.apps.outofpocket.dto.UserDTO;

public class UserDAO {
private static final Logger LOG = Logger.getLogger(UserDAO.class.getCanonicalName());
	
	private static final String FIRST_NAME = "firstName";
	private static final String LAST_NAME = "lastName";
	private static final String EMAIL = "email";
	private static final String PASSWORD = "password";
	private static final String ACCT_TYPE = "accountType";
	
	private Key getKey(String name) {
		Key key = KeyFactory.createKey("UserKey", name);
		
		return key;
	}
	
	public boolean save(UserDTO user) {
		if(user == null) {
			LOG.warning("Save method called with NULL object");
			return false;
		}
		
		Key userKey = getKey(user.getEmail());
		Entity userE = new Entity("User", userKey);
		userE.setProperty(FIRST_NAME, user.getFirstName());
		userE.setProperty(LAST_NAME, user.getLastName());
		userE.setProperty(EMAIL, user.getEmail());
		userE.setProperty(PASSWORD, user.getPassword());
		userE.setProperty(ACCT_TYPE, user.getAccountType().toString());
		
		DatastoreService dataStore = DatastoreServiceFactory.getDatastoreService();
		dataStore.put(userE);
		
		return true;
	}
	
	public List<UserDTO> findAll() {
		return null;
	}
}
