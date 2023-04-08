package com.example.facade_goods.service;

import com.example.facade_goods.dto.GoodsDto;

import java.util.List;

public interface GoodsService {
    GoodsDto getGoodsByName(String name);

    List<GoodsDto> getAllGoods();

    void saveGoods(GoodsDto goods);

    void deleteGoodsByName(String name);

    void updateGoodsById(Integer id, GoodsDto newGoods);
}
