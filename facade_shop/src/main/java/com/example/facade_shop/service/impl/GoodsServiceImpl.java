package com.example.facade_shop.service.impl;

import com.example.facade_shop.client.GoodsClient;
import com.example.facade_shop.model.Goods;
import com.example.facade_shop.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor

@Service
public class GoodsServiceImpl implements GoodsService {

    private final GoodsClient client;

    @Override
    public Goods getGoodsByName(String name) {
        return client.getGoodsByName(name);
    }

    @Override
    public List<Goods> getAllGoods() {
        return client.getAllGoods();
    }

    @Override
    public void saveGoods(Goods goods) {
        client.saveGoods(goods);
    }

    @Override
    public void deleteGoodsByName(String name) {
        client.deleteGoodsByName(name);
    }

    @Override
    public void updateGoodsDescriptionById(Integer id, Goods newGoods) {
        client.updateGoodsDescriptionById(id, newGoods);
    }
}
