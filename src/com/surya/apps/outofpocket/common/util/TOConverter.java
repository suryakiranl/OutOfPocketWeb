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

public final class TOConverter {
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

	public static final void updateWhoColumns(BasePO source, BaseDTO dest) {
		if (source.getId() != null)
			dest.setId(source.getId());
		dest.setCreatedBy(source.getCreatedBy());
		dest.setCreatedTime(source.getCreatedTime());
		dest.setModifiedBy(source.getModifiedBy());
		dest.setModifiedTime(source.getModifiedTime());
	}

	public static final void updateWhoColumns(BaseDTO source, BasePO dest) {
		if (source.getId() != 0)
			dest.setId(source.getId());
		dest.setCreatedBy(source.getCreatedBy());
		dest.setCreatedTime(source.getCreatedTime());
		dest.setModifiedBy(source.getModifiedBy());
		dest.setModifiedTime(source.getModifiedTime());
	}

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
