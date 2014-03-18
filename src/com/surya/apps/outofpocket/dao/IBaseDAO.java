package com.surya.apps.outofpocket.dao;

import java.util.List;

import com.surya.apps.outofpocket.po.BasePO;

public interface IBaseDAO<PO extends BasePO> {
	PO save(PO po);
	PO findById(long id);
	List<PO> findAll();
}
