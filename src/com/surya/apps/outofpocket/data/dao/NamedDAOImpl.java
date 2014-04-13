package com.surya.apps.outofpocket.data.dao;

import java.util.List;

import javax.persistence.Query;

import com.surya.apps.outofpocket.data.po.NamedPO;

public class NamedDAOImpl<PO extends NamedPO> extends BaseDAOImpl<PO> implements
		INamedDAO<PO> {
	public NamedDAOImpl(Class<PO> po) {
		super(po);
	}

	@Override
	public List<PO> findByName(String name) {
		final String findByNameQuery = "select po from " + getPOClassName()
				+ " po where name = ?";
		Query q = getEntityManager().createQuery(findByNameQuery);
		q.setParameter(1, name);

		return executeQuery(q);
	}

	@Override
	public List<PO> findObjectsMatchingNameLike(String name) {
		final String findObjsMatchingQuery = "select po from "
				+ getPOClassName() + " po where name like ?";

		Query q = getEntityManager().createQuery(findObjsMatchingQuery);
		q.setParameter(1, name);

		return executeQuery(q);
	}
}
