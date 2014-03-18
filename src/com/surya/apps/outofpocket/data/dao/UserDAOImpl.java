package com.surya.apps.outofpocket.data.dao;

import java.util.List;

import javax.persistence.Query;

import com.surya.apps.outofpocket.common.util.Logger;
import com.surya.apps.outofpocket.data.po.UserPO;

public class UserDAOImpl extends NamedDAOImpl<UserPO> implements
		IUserDAO<UserPO> {
	private static final Logger log = Logger.get();

	public UserDAOImpl() {
		super(UserPO.class);
	}

	@Override
	public UserPO findByEmail(String email) {
		Query q = getSession().createQuery(
				"select po from " + getPOClassName() + " po where email = ?");
		q.setParameter(1, email);

		@SuppressWarnings("unchecked")
		List<UserPO> pos = q.getResultList();

		UserPO po = null;
		if (pos != null && pos.size() != 0) {
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
