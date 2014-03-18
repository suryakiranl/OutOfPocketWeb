package com.surya.apps.outofpocket.dao;

import com.surya.apps.outofpocket.po.NamedPO;

public interface IUserDAO<PO extends NamedPO> extends INamedDAO<PO> {
	PO findByEmail(String email);
}
