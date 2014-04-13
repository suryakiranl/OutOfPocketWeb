package com.surya.apps.outofpocket.data.dao;

import java.util.List;

import com.surya.apps.outofpocket.data.po.NamedPO;

public interface INamedDAO<PO extends NamedPO> extends IBaseDAO<PO> {
	List<PO> findByName(String name);
	List<PO> findObjectsMatchingNameLike(String name);
}
