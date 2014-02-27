package com.surya.apps.outofpocket.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlElementWrapper;

import com.surya.apps.outofpocket.dao.UserDAO;
import com.surya.apps.outofpocket.dto.UserDTO;

@Path("/users")
public class UserService {
	private static final Logger LOG = Logger.getLogger(UserService.class.getCanonicalName());
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces( {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON} )
	public UserDTO createUser(UserDTO user) {
		LOG.entering(UserService.class.getCanonicalName(), "createUser");
		if(user.getAccountType() == null) {
			user.setAccountType(UserDTO.AccountType.NATIVE);
		}
		
		LOG.fine("User to be created :: " + user);
		
		UserDAO userDao = new UserDAO();
		if(userDao.save(user)) {
			LOG.finest("User account saved successfully.");
		} else {
			LOG.warning("Error when saving user account.");
		}
		
		LOG.exiting(UserService.class.getCanonicalName(), "createUser");
		return user;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@XmlElementWrapper(name = "users")
	public List<UserDTO> fetchAll() {
		List<UserDTO> list = new ArrayList<UserDTO>();
		
		UserDTO user = new UserDTO();
		user.setFirstName("Surya");
		user.setLastName("Kiran");
		user.setEmail("surya@cmu.edu");
		user.setPassword("Passwordaaaa");
		
		list.add(user);
		
		return list;
	}
}
