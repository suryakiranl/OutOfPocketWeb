package com.surya.apps.outofpocket.data.dao;

import java.util.List;

import javax.persistence.Query;

import com.surya.apps.outofpocket.data.po.NamedPO;

/**
 * Generic DAO Base class which all DAOs implementing Named entities
 * should implement.
 * 
 * @author surya
 *
 * @param <PO> - Entity Extending NamedPO
 */
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
}
