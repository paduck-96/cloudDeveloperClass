package com.kakao.school.service;

import java.util.List;

import javax.swing.text.html.parser.Entity;

import com.kakao.school.domain.ItemEntity;
import com.kakao.school.dto.ItemDto;

public interface ItemService {
	// 전체 데이터 가져오는 메서드
	public List<ItemDto> allItem();
	
	// DTO 를 Entity로 변환하는 메서드
	public default ItemEntity dtoToEntity(ItemDto dto) {
		ItemEntity entity = ItemEntity.builder()
				.itemid(dto.getItemid())
				.itemname(dto.getItemname())
				.description(dto.getDescription())
				.pictureurl(dto.getPictureurl())
				.price(dto.getPrice())
				.build();
		
		return entity;
	}
	
	// Entity 를 DTO 로 변환하는 메서드
	public default ItemDto entityToDTO(ItemEntity entity) {
		ItemDto dto = ItemDto.builder()
				.itemid(entity.getItemid())
				.itemname(entity.getItemname())
				.description(entity.getDescription())
				.price(entity.getPrice())
				.pictureurl(entity.getPictureurl())
				.build();
		
		return dto;
	}
}
