package com.surya.apps.outofpocket.data.dao;

import java.util.List;

import javax.persistence.Query;

import com.surya.apps.outofpocket.common.util.Logger;
import com.surya.apps.outofpocket.data.po.UserPO;

/**
 * IUserDAO implementation using JPA.
 * 
 * @author surya
 * 
 */
public class UserDAOImpl extends NamedDAOImpl<UserPO> implements
		IUserDAO<UserPO> {
	private static final Logger log = Logger.get();

	public UserDAOImpl() {
		super(UserPO.class);
	}

	@Override
	public UserPO findByEmail(String email) {
		UserPO po = null;

		final String findUsersByEmail = "select po from " + getPOClassName()
				+ " po where email = ?";
		Query q = getEntityManager().createQuery(findUsersByEmail);
		q.setParameter(1, email);

		List<UserPO> pos = executeQuery(q);

		if (pos != null && pos.size() != 0) {
			// Check if there are more than one accounts being registered 
			// with the same email ID.
			if (pos.size() > 1) {
				String message = "More than one user account retrieved with email: "
						+ email;
				log.error(message);
				throw new RuntimeException(message);
			} else {
				po = pos.get(0);
			}
		}

		return po;
	}

}
