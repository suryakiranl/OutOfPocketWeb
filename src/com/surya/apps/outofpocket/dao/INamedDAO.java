package com.surya.apps.outofpocket.dao;

import java.util.List;

import com.surya.apps.outofpocket.po.NamedPO;

public interface INamedDAO<PO extends NamedPO> extends IBaseDAO<PO> {
	List<PO> findByName(String name);
}
