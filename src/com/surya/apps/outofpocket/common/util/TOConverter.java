package com.surya.apps.outofpocket.common.util;

import com.surya.apps.outofpocket.business.dto.BaseDTO;
import com.surya.apps.outofpocket.business.dto.ExpenseDTO;
import com.surya.apps.outofpocket.business.dto.ExpenseTypeDTO;
import com.surya.apps.outofpocket.business.dto.GroupDTO;
import com.surya.apps.outofpocket.business.dto.UserDTO;
import com.surya.apps.outofpocket.data.po.BasePO;
import com.surya.apps.outofpocket.data.po.ExpensePO;
import com.surya.apps.outofpocket.data.po.ExpenseTypePO;
import com.surya.apps.outofpocket.data.po.GroupPO;
import com.surya.apps.outofpocket.data.po.UserPO;

/**
 * Utility converter class to convert DTO objects to corresponding TO objects,
 * and vice versa. Note that methods return NULL if the parameter passed is
 * NULL.
 * 
 * @author surya
 * 
 */
public final class TOConverter {
	/**
	 * Convert User DTO to PO object
	 * 
	 * @param dto - DTO object
	 * @return - PO object
	 */
	public static final UserPO getUserPO(UserDTO dto) {
		if (dto == null) {
			return null;
		}

		UserPO po = new UserPO();

		po.setActive(dto.isActive());
		po.setEmail(dto.getEmail());
		po.setName(dto.getName());
		po.setPassword(dto.getPassword());

		updateWhoColumns(dto, po);

		return po;
	}

	/**
	 * Convert User PO to DTO object
	 * 
	 * @param po - PO object
	 * @return - DTO object
	 */
	public static final UserDTO getUserDTO(UserPO po) {
		if (po == null) {
			return null;
		}

		UserDTO dto = new UserDTO();

		dto.setActive(po.isActive());
		dto.setEmail(po.getEmail());
		dto.setName(po.getName());
		dto.setPassword(po.getPassword());

		updateWhoColumns(po, dto);

		return dto;
	}

	/**
	 * Utility method to update the WHO columns in the object from
	 * source to destination.
	 * 
	 * @param source - PO object
	 * @param dest - DTO object
	 */
	public static final void updateWhoColumns(BasePO source, BaseDTO dest) {
		if (source.getId() != null)
			dest.setId(source.getId());
		dest.setCreatedBy(source.getCreatedBy());
		dest.setCreatedTime(source.getCreatedTime());
		dest.setModifiedBy(source.getModifiedBy());
		dest.setModifiedTime(source.getModifiedTime());
	}

	/**
	 * Utility method to update the WHO columns in the object from
	 * source to destination.
	 * 
	 * @param source - DTO object
	 * @param dest - PO object
	 */
	public static final void updateWhoColumns(BaseDTO source, BasePO dest) {
		if (source.getId() != 0)
			dest.setId(source.getId());
		dest.setCreatedBy(source.getCreatedBy());
		dest.setCreatedTime(source.getCreatedTime());
		dest.setModifiedBy(source.getModifiedBy());
		dest.setModifiedTime(source.getModifiedTime());
	}

	/**
	 * Convert Group PO to DTO object
	 * 
	 * @param po - PO object
	 * @return - DTO object
	 */
	public static final GroupDTO getGroupDTO(GroupPO po) {
		if (po == null) {
			return null;
		}

		GroupDTO dto = new GroupDTO();

		dto.setName(po.getName());
		dto.setOwnerId(po.getOwnerId());

		updateWhoColumns(po, dto);

		return dto;
	}

	/**
	 * Convert Group DTO to PO object
	 * 
	 * @param dto - DTO object
	 * @return - PO object
	 */
	public static final GroupPO getGroupPO(GroupDTO dto) {
		if (dto == null) {
			return null;
		}

		GroupPO po = new GroupPO();

		po.setName(dto.getName());
		po.setOwnerId(dto.getOwnerId());

		updateWhoColumns(dto, po);

		return po;
	}

	/**
	 * Convert Expense PO to DTO object
	 * 
	 * @param po - PO object
	 * @return - DTO object
	 */
	public static final ExpenseDTO getExpenseDTO(ExpensePO po) {
		if (po == null) {
			return null;
		}

		ExpenseDTO dto = new ExpenseDTO();

		dto.setAmount(po.getAmount());
		dto.setBillDate(po.getBillDate());
		dto.setExpenseType(getExpenseTypeDTO(po.getExpenseType()));
		dto.setGroup(getGroupDTO(po.getGroup()));
		dto.setName(po.getName());

		updateWhoColumns(po, dto);

		return dto;
	}

	/**
	 * Convert Expense DTO to PO object
	 * 
	 * @param dto - DTO object
	 * @return - PO object
	 */
	public static final ExpensePO getExpensePO(ExpenseDTO dto) {
		if (dto == null) {
			return null;
		}

		ExpensePO po = new ExpensePO();

		po.setAmount(dto.getAmount());
		po.setBillDate(dto.getBillDate());
		po.setExpenseType(getExpenseTypePO(dto.getExpenseType()));
		po.setGroup(getGroupPO(dto.getGroup()));
		po.setName(dto.getName());

		updateWhoColumns(dto, po);

		return po;
	}

	/**
	 * Convert ExpenseType PO to DTO object
	 * 
	 * @param po - PO object
	 * @return - DTO object
	 */
	public static final ExpenseTypeDTO getExpenseTypeDTO(ExpenseTypePO po) {
		if (po == null) {
			return null;
		}

		ExpenseTypeDTO dto = new ExpenseTypeDTO();

		dto.setDescription(po.getDescription());
		dto.setName(po.getName());
		dto.setOwnerId(po.getOwnerId());

		updateWhoColumns(po, dto);

		return dto;
	}

	/**
	 * Convert ExpenseType DTO to PO object
	 * 
	 * @param dto - DTO object
	 * @return - PO object
	 */
	public static final ExpenseTypePO getExpenseTypePO(ExpenseTypeDTO dto) {
		if (dto == null) {
			return null;
		}

		ExpenseTypePO po = new ExpenseTypePO();

		po.setDescription(dto.getDescription());
		po.setName(dto.getName());
		po.setOwnerId(dto.getOwnerId());

		updateWhoColumns(dto, po);

		return po;
	}
}
