package com.surya.apps.outofpocket.data.dao;

import com.surya.apps.outofpocket.data.po.NamedPO;

/**
 * User DAO Interface. Contains methods to maintain user information. 
 * 
 * @author surya
 *
 * @param <PO> - UserPO
 */
public interface IUserDAO<PO extends NamedPO> extends INamedDAO<PO> {
	PO findByEmail(String email);
}
