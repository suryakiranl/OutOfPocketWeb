package com.surya.apps.outofpocket.business.util;

import java.util.ArrayList;
import java.util.List;

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

	public List<BaseDTO> getDTOs(List<BasePO> pos) {
		List<BaseDTO> dtos = new ArrayList<BaseDTO>();

		for (BasePO po : pos) {
			if (po instanceof UserPO) {
				dtos.add(getUserDTO((UserPO) po));
			}
		}

		return dtos;
	}

	public List<BasePO> getPOs(List<BaseDTO> dtos) {
		List<BasePO> pos = new ArrayList<BasePO>();

		for (BaseDTO dto : dtos) {
			if (dto instanceof UserDTO) {
				pos.add(getUserPO((UserDTO) dto));
			}
		}

		return pos;
	}

	public static final void updateWhoColumns(BasePO source, BaseDTO dest) {
		dest.setCreatedBy(source.getCreatedBy());
		dest.setCreatedTime(source.getCreatedTime());
		dest.setId(source.getId());
		dest.setModifiedBy(source.getModifiedBy());
		dest.setModifiedTime(source.getModifiedTime());
	}

	public static final void updateWhoColumns(BaseDTO source, BasePO dest) {
		dest.setCreatedBy(source.getCreatedBy());
		dest.setCreatedTime(source.getCreatedTime());
		dest.setId(source.getId());
		dest.setModifiedBy(source.getModifiedBy());
		dest.setModifiedTime(source.getModifiedTime());
	}
}
