package com.example.facade_shop.service;

import com.example.facade_shop.model.Goods;

import java.util.List;

public interface GoodsService {

    Goods getGoodsByName(String name);

    List<Goods> getAllGoods();

    void saveGoods(Goods goods);

    void deleteGoodsByName(String name);

    void updateGoodsDescriptionById(Integer id, Goods newGoods);

}
