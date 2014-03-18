package com.surya.apps.outofpocket.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.surya.apps.outofpocket.common.util.Logger;
import com.surya.apps.outofpocket.dao.util.EMF;
import com.surya.apps.outofpocket.po.BasePO;

public class BaseDAOImpl<PO extends BasePO> implements IBaseDAO<PO> {
	private static final Logger log = Logger.get();
	private BasePO po;
	
	public BaseDAOImpl(BasePO po) {
		this.po = po;
	}
	
	@Override
	public PO save(PO po) {
		log.enter(po);
		
		if(po != null) {
			// If the object already exists in the system
			// merge changes
			if(po.getId() != 0) {
				getSession().merge(po);
			} else { // Else, create a new object
				getSession().persist(po);
			}
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
		String className = po.getClass().getSimpleName();
		Query q = getSession().createQuery("select po from " + className + " po where id = ?");
		q.setParameter(1, id);
		
		@SuppressWarnings("unchecked")
		List<PO> rs = q.getResultList();
		
		if(rs == null || rs.size() == 0) {
			returnObj = null;
		} else {
			returnObj = rs.get(0);
		}
		
		return returnObj;
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
