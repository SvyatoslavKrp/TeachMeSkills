package com.example.facade_shop.client;

import com.example.facade_shop.config.FeignConfiguration;
import com.example.facade_shop.model.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(
        name = "goodsClient",
        url = "http://127.0.0.1:8081/goods/",
        configuration = FeignConfiguration.class
)
public interface GoodsClient {

    @GetMapping("/{name}")
    Goods getGoodsByName(@PathVariable(name = "name") String name);

    @GetMapping
    List<Goods> getAllGoods();

    @PostMapping("/save")
    void saveGoods(@RequestBody Goods goods);

    @DeleteMapping("/delete/{name}")
    void deleteGoodsByName(@PathVariable(name = "name") String name);

    @PutMapping("/update/{id}")
    void updateGoodsDescriptionById(@PathVariable Integer id, @RequestBody Goods newGoods);

}
