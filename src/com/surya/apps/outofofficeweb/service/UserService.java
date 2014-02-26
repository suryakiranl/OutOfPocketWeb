package com.surya.apps.outofofficeweb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlElementWrapper;

import com.surya.apps.outofofficeweb.dao.UserDAO;
import com.surya.apps.outofofficeweb.dto.User;

@Path("/users")
public class UserService {
	private static final Logger LOG = Logger.getLogger(UserService.class.getCanonicalName());
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@XmlElementWrapper(name = "users")
	public List<User> fetchAll() {
		ArrayList<User> list = new ArrayList<User>();
		
		return list;
	}
	
	@GET
	@Produces( {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON} )
	@Path("/{id}")
	public User findUser(@PathParam("loginId") String loginId) {
		LOG.fine("Finding user with ID: " + loginId);
		
		User u = new User();
		u.setFirstName("Surya");
		u.setEmail("suryakiranl@gmail.com");
		u.setPassword("MAJKSHDKJASHDA");
		u.setAccountType(User.AccountType.NATIVE);
		u.setLoginId(loginId);
		
		return u;
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces( {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON} )
	public User createUser(User user) {
		LOG.entering(UserService.class.getCanonicalName(), "createUser");
		
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
	
	@PUT
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces( {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON} )
	public User updateUser(User user) {
		LOG.fine("Inside POST method of User :" + user);
		
		return user;
	}
	
	@DELETE
	@Path("/delete/{id}")
	public void deleteUser(@PathParam("id") Long id) {
		LOG.fine("User requested for deletion: " + id);
	}
	
}
