package com.example.facade_goods.mapper;

import com.example.facade_goods.domain.GoodsEntity;
import com.example.facade_goods.dto.GoodsDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface GoodsMapper {

    GoodsDto toDto(GoodsEntity entity);

    GoodsEntity toEntity(GoodsDto dto);

    List<GoodsDto> listToDto(List<GoodsEntity> entities);

}
