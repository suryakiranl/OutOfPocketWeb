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
import com.surya.apps.outofpocket.common.util.TOConverter;
import com.surya.apps.outofpocket.data.dao.DAOFactory;
import com.surya.apps.outofpocket.data.dao.IUserDAO;
import com.surya.apps.outofpocket.data.po.UserPO;

@Path("/users")
public class UserService {
	private static final Logger LOG = Logger.get();
	private IUserDAO<UserPO> dao = DAOFactory.get().getUserDAO(); 
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces( {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON} )
	public UserDTO createUser(UserDTO user) {
		LOG.enter(user);
		
		UserPO userPO = TOConverter.getUserPO(user);
		userPO = dao.save(userPO);
		user = TOConverter.getUserDTO(userPO);
		
		LOG.exit(user);
		return user;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@XmlElementWrapper(name = "users")
	public List<UserDTO> findAll() {
		LOG.enter();
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		
		List<UserPO> userPOs = dao.findAll();
		for(UserPO po : userPOs) {
			userDTOs.add(TOConverter.getUserDTO(po));
		}
		
		LOG.exit(userDTOs);
		
		return userDTOs;
	}
}
