package com.surya.apps.outofpocket.data.dao;

import com.surya.apps.outofpocket.data.po.GroupPO;

public class GroupDAOImpl extends NamedDAOImpl<GroupPO> implements
		IGroupDAO<GroupPO> {

	public GroupDAOImpl() {
		super(GroupPO.class);
	}

}
