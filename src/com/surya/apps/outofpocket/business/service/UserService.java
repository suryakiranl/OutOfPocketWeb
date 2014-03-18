package com.surya.apps.outofpocket.business.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlElementWrapper;

import com.surya.apps.outofpocket.business.dto.UserDTO;
import com.surya.apps.outofpocket.common.util.Logger;
import com.surya.apps.outofpocket.data.dao.UserJDO;

@Path("/users")
public class UserService {
	private static final Logger LOG = Logger.get();
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces( {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON} )
	public UserDTO createUser(UserDTO user) {
		LOG.enter(user);
		
		UserJDO userDao = new UserJDO();
		if(userDao.save(user)) {
			LOG.debug("User account saved successfully.");
		} else {
			LOG.warn("Error when saving user account.");
		}
		
		LOG.exit(user);
		return user;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@XmlElementWrapper(name = "users")
	public List<UserDTO> fetchAll() {
		List<UserDTO> list = new ArrayList<UserDTO>();
		
		UserDTO user = new UserDTO();
		user.setName("Surya Kiran");
		user.setEmail("surya@cmu.edu");
		user.setPassword("Passwordaaaa");
		
		list.add(user);
		
		return list;
	}
}