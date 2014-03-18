package com.surya.apps.outofpocket.data.dao;

import com.surya.apps.outofpocket.data.po.NamedPO;

public interface IUserDAO<PO extends NamedPO> extends INamedDAO<PO> {
	PO findByEmail(String email);
}
