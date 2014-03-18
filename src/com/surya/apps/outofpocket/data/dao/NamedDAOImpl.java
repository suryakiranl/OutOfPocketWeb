package com.surya.apps.outofpocket.data.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.surya.apps.outofpocket.data.dao.util.EMF;
import com.surya.apps.outofpocket.data.po.NamedPO;

public class NamedDAOImpl<PO extends NamedPO> extends BaseDAOImpl<PO> implements
		INamedDAO<PO> {
	public NamedDAOImpl(Class<PO> po) {
		super(po);
	}

	@Override
	public List<PO> findByName(String name) {
		List<PO> pos = null;

		EntityManager em = EMF.get().createEntityManager();
		try {
			Query q = em.createQuery("select po from " + getPOClassName()
					+ " po where name = ?");
			q.setParameter(1, name);

			pos = q.getResultList();
		} finally {
			// em.close();
		}

		return pos;
	}
}
