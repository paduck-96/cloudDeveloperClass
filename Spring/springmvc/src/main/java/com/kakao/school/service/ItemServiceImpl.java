package com.kakao.school.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kakao.school.domain.ItemEntity;
import com.kakao.school.dto.ItemDto;
import com.kakao.school.persistence.ItemMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
	//@Autowired
	private final ItemMapper itemMapper;

	@Override
	public List<ItemDto> allItem() {
		List<ItemDto> list = new ArrayList<>();
		// Repository �޼��� ȣ��
		List<ItemEntity> result = itemMapper.allItem();
		// ��� ��ȯ
		for(ItemEntity entity : result) {
			list.add(entityToDTO(entity));
		}
		
		return list;
	}
}
