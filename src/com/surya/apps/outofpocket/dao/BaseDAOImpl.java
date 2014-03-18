package com.surya.apps.outofpocket.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.surya.apps.outofpocket.dao.util.EMF;
import com.surya.apps.outofpocket.po.BasePO;

public class BaseDAOImpl<PO extends BasePO> implements IBaseDAO<PO> {
	@Override
	public PO save(PO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PO findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	protected final EntityManager getSession() {
		return EMF.get().createEntityManager();
	}

	protected void commit() {
		EntityManager em = getSession();
		if (em.isOpen() && (em.getTransaction() != null)
				&& (em.getTransaction().isActive())) {
			em.getTransaction().commit();
		} else {
			
		}
	}

	protected void rollback() {
		EntityManager em = getSession();
		if (em.isOpen() && (em.getTransaction() != null)
				&& (em.getTransaction().isActive())) {
			em.getTransaction().rollback();
		}
	}

}
