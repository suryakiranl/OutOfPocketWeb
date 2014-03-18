package com.surya.apps.outofpocket.data.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.surya.apps.outofpocket.common.util.Logger;
import com.surya.apps.outofpocket.data.dao.util.EMF;
import com.surya.apps.outofpocket.data.po.BasePO;

public class BaseDAOImpl<PO extends BasePO> implements IBaseDAO<PO> {
	private static final Logger log = Logger.get();
	private Class<PO> poClass;

	public BaseDAOImpl(Class<PO> po) {
		this.poClass = po;
	}

	@Override
	public PO save(PO po) {
		log.enter(po);

		if (po != null) {
			// If the object already exists in the system
			// merge changes
			if (po.getId() != 0) {
				getSession().merge(po);
			} else { // Else, create a new object
				getSession().persist(po);
			}
			commit();
		} else {
			log.warn("Nothing to save as parameter is NULL.");
		}

		log.exit(po);
		return null;
	}

	@Override
	public PO findById(long id) {
		log.enter(id);

		PO returnObj;
		Query q = getSession().createQuery(
				"select po from " + getPOClassName() + " po where id = ?");
		q.setParameter(1, id);

		@SuppressWarnings("unchecked")
		List<PO> pos = q.getResultList();

		if (pos == null || pos.size() == 0) {
			returnObj = null;
		} else {
			returnObj = pos.get(0);
		}

		return returnObj;
	}

	@Override
	public List<PO> findAll() {
		Query q = getSession().createQuery(
				"select po from " + getPOClassName() + " po");

		@SuppressWarnings("unchecked")
		List<PO> pos = q.getResultList();

		return pos;
	}

	protected final EntityManager getSession() {
		return EMF.get().createEntityManager();
	}

	protected void commit() {
		EntityManager em = getSession();
		if (em.isOpen() && (em.getTransaction() != null)
				&& (em.getTransaction().isActive())) {
			em.getTransaction().commit();
			log.finer("Transaction committed");
		} else {
			log.warn("Nothing to commit");
		}
	}

	protected void rollback() {
		EntityManager em = getSession();
		if (em.isOpen() && (em.getTransaction() != null)
				&& (em.getTransaction().isActive())) {
			em.getTransaction().rollback();
			log.finer("Transaction rolledback");
		} else {
			log.warn("Nothing to rollback");
		}
	}

	protected final String getPOClassName() {
		return poClass.getSimpleName();
	}
}
