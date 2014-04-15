package com.surya.apps.outofpocket.data.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.surya.apps.outofpocket.common.util.Logger;
import com.surya.apps.outofpocket.data.dao.util.EMF;
import com.surya.apps.outofpocket.data.po.BasePO;

/**
 * Base DAO implementation class which has method implementations for 
 * general operations like - save, find etc.
 * 
 * @author surya
 *
 * @param <PO> - Any class extending BasePO
 */
public class BaseDAOImpl<PO extends BasePO> implements IBaseDAO<PO> {
	private static final Logger log = Logger.get();
	private Class<PO> poClass;

	public BaseDAOImpl(Class<PO> po) {
		this.poClass = po;
	}

	@Override
	public PO save(PO po) {
		log.enter(po);

		if (po == null) {
			log.warn("Nothing to save as PO is NULL.");
			return null;
		}

		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			// If the object already exists in the system
			// merge changes
			if (po.getId() != null && po.getId() != 0) {
				em.merge(po);
			} else { // Else, create a new object
				em.persist(po);
			}
			em.getTransaction().commit();
		} finally {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}

		log.exit(po);

		return po;
	}

	@Override
	public PO findById(long id) {
		log.enter(id);

		final String findByIdQuery = "select po from " + getPOClassName()
				+ " po where id = ?";

		Query q = getEntityManager().createQuery(findByIdQuery);
		q.setParameter(1, id);
		List<PO> pos = executeQuery(q);

		PO po = null;
		if (pos != null && pos.size() > 0) {
			po = pos.get(0);
		}

		return po;
	}

	@Override
	public List<PO> findAll() {
		final String findAllQuery = "select po from " + getPOClassName()
				+ " po";

		return executeQuery(findAllQuery);
	}

	protected List<PO> executeQuery(String queryStr) {
		Query q = getEntityManager().createQuery(queryStr);
		@SuppressWarnings("unchecked")
		List<PO> pos = q.getResultList();

		return pos;
	}

	protected List<PO> executeQuery(Query q) {
		@SuppressWarnings("unchecked")
		List<PO> pos = q.getResultList();

		return pos;
	}

	protected final String getPOClassName() {
		return poClass.getSimpleName();
	}
	
	protected final EntityManager getEntityManager() {
		return EMF.get().createEntityManager();
	}
}
