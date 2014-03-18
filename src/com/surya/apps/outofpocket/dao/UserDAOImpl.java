package com.surya.apps.outofpocket.dao;

import com.surya.apps.outofpocket.po.UserPO;

public class UserDAOImpl extends NamedDAOImpl<UserPO> implements IUserDAO<UserPO> {

	public UserDAOImpl() {
		super(UserPO.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public UserPO findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
