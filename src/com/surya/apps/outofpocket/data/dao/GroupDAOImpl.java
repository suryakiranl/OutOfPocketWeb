package com.surya.apps.outofpocket.data.dao;

import com.surya.apps.outofpocket.data.po.GroupPO;

/**
 * DAO Implementation for maintaining Group information.
 * 
 * @author surya
 *
 */
public class GroupDAOImpl extends NamedDAOImpl<GroupPO> implements
		IGroupDAO<GroupPO> {

	public GroupDAOImpl() {
		super(GroupPO.class);
	}

}
