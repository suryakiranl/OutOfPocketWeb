package com.surya.apps.outofpocket.data.dao;

import java.util.List;

import com.surya.apps.outofpocket.data.po.NamedPO;

/**
 * Interface which defines methods to be implemented for a named
 * persistent entity. 
 *  
 * @author surya
 *
 * @param <PO> - Any class extending NamedPO
 */
public interface INamedDAO<PO extends NamedPO> extends IBaseDAO<PO> {
	List<PO> findByName(String name);
}
