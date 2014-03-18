package com.surya.apps.outofpocket.dao;

import java.util.List;

import javax.persistence.Query;

import com.surya.apps.outofpocket.po.NamedPO;

public class NamedDAOImpl<PO extends NamedPO> extends BaseDAOImpl<PO> implements
		INamedDAO<PO> {
	public NamedDAOImpl(Class<PO> po) {
		super(po);
	}

	@Override
	public List<PO> findByName(String name) {
		Query q = getSession().createQuery(
				"select po from " + getPOClassName() + " po where name = ?");
		q.setParameter(1, name);

		@SuppressWarnings("unchecked")
		List<PO> pos = q.getResultList();

		return pos;
	}
}
