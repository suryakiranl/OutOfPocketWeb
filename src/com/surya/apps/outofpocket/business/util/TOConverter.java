package com.surya.apps.outofpocket.business.util;

import com.surya.apps.outofpocket.business.dto.BaseDTO;
import com.surya.apps.outofpocket.business.dto.UserDTO;
import com.surya.apps.outofpocket.data.po.BasePO;
import com.surya.apps.outofpocket.data.po.UserPO;

public final class TOConverter {
	public static final UserPO getUserPO(UserDTO dto) {
		UserPO po = new UserPO();

		po.setActive(dto.isActive());
		po.setEmail(dto.getEmail());
		po.setName(dto.getName());
		po.setPassword(dto.getPassword());
		updateWhoColumns(dto, po);

		return po;
	}

	public static final UserDTO getUserDTO(UserPO po) {
		UserDTO dto = new UserDTO();

		dto.setActive(po.isActive());
		dto.setEmail(po.getEmail());
		dto.setName(po.getName());
		dto.setPassword(po.getPassword());
		updateWhoColumns(po, dto);

		return dto;
	}

	public static final void updateWhoColumns(BasePO source, BaseDTO dest) {
		if(source.getId() != null) dest.setId(source.getId());
		dest.setCreatedBy(source.getCreatedBy());
		dest.setCreatedTime(source.getCreatedTime());
		dest.setModifiedBy(source.getModifiedBy());
		dest.setModifiedTime(source.getModifiedTime());
	}

	public static final void updateWhoColumns(BaseDTO source, BasePO dest) {
		if(source.getId() != 0) dest.setId(source.getId());
		dest.setCreatedBy(source.getCreatedBy());
		dest.setCreatedTime(source.getCreatedTime());
		dest.setModifiedBy(source.getModifiedBy());
		dest.setModifiedTime(source.getModifiedTime());
	}
}
