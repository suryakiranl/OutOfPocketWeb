package com.surya.apps.outofpocket.data.dao;

import com.surya.apps.outofpocket.data.po.GroupPO;
import com.surya.apps.outofpocket.data.po.UserPO;

/**
 * DAO Factory class which provides specific implementation classes.
 * 
 * @author surya
 *
 */
public class DAOFactory {
	private static final DAOFactory DAO_FACTORY = new DAOFactory();
	
	public static final DAOFactory get() {
		return DAO_FACTORY;
	}
	
	public final IUserDAO<UserPO> getUserDAO() {
		return new UserDAOImpl();
	}
	
	public final IGroupDAO<GroupPO> getGroupDAO() {
		return new GroupDAOImpl();
	}
}
