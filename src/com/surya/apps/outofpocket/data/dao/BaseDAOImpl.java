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
			EntityManager em = EMF.get().createEntityManager();
			try {
				// If the object already exists in the system
				// merge changes
				if (po.getId() != null && po.getId() != 0) {
					em.merge(po);
				} else { // Else, create a new object
					em.persist(po);
				}
			} finally {
				em.close();
			}
		} else {
			log.warn("Nothing to save as parameter is NULL.");
		}

		log.exit(po);

		return po;
	}

	@Override
	public PO findById(long id) {
		log.enter(id);

		PO po = null;
		EntityManager em = EMF.get().createEntityManager();
		try {
			Query q = em.createQuery("select po from " + getPOClassName()
					+ " po where id = ?");
			q.setParameter(1, id);

			@SuppressWarnings("unchecked")
			List<PO> pos = q.getResultList();

			if (pos == null || pos.size() == 0) {
				po = null;
			} else {
				po = pos.get(0);
			}
		} finally {
			// em.close();
		}

		return po;
	}

	@Override
	public List<PO> findAll() {
		List<PO> pos = null;
		EntityManager em = EMF.get().createEntityManager();
		try {
			Query q = em.createQuery("select po from " + getPOClassName()
					+ " po");

			pos = q.getResultList();
		} finally {
			// em.close();
		}

		return pos;
	}

	protected final String getPOClassName() {
		return poClass.getSimpleName();
	}
}
