package com.surya.apps.outofpocket.data.dao;

import java.util.List;

import com.surya.apps.outofpocket.data.po.BasePO;

/**
 * Base DAO interface which defines the common methods any DAO should implement.
 * 
 * @author surya
 * 
 * @param <PO> - Any object extending from BasePO
 */
public interface IBaseDAO<PO extends BasePO> {
	PO save(PO po);

	PO findById(long id);

	List<PO> findAll();
}
