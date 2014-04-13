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

import com.surya.apps.outofpocket.business.dto.GroupDTO;
import com.surya.apps.outofpocket.common.util.Logger;
import com.surya.apps.outofpocket.common.util.TOConverter;
import com.surya.apps.outofpocket.data.dao.DAOFactory;
import com.surya.apps.outofpocket.data.dao.IGroupDAO;
import com.surya.apps.outofpocket.data.po.GroupPO;

@Path("/groups")
public class GroupService {
	private static final Logger LOG = Logger.get();
	private IGroupDAO<GroupPO> dao = DAOFactory.get().getGroupDAO();

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public GroupDTO createGroup(GroupDTO group) {
		LOG.enter(group);

		GroupPO groupPO = TOConverter.getGroupPO(group);
		groupPO = dao.save(groupPO);
		group = TOConverter.getGroupDTO(groupPO);

		LOG.exit(group);

		return group;
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@XmlElementWrapper(name = "groups")
	public List<GroupDTO> findAll() {
		List<GroupDTO> groupDTOs = new ArrayList<GroupDTO>();

		List<GroupPO> groupPOs = dao.findAll();
		for (GroupPO po : groupPOs) {
			groupDTOs.add(TOConverter.getGroupDTO(po));
		}

		LOG.exit(groupDTOs);

		return groupDTOs;
	}
}
