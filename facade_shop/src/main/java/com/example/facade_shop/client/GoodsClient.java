package com.example.facade_shop.client;

import com.example.facade_shop.config.FeignConfiguration;
import com.example.facade_shop.model.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(
        name = "goodsClient",
        url = "http://127.0.0.1:8081/",
        configuration = FeignConfiguration.class
)
public interface GoodsClient {

    @GetMapping("goods/{name}")
    Goods getGoodsByName(@PathVariable(name = "name") String name);

    @GetMapping("/goods")
    List<Goods> getAllGoods();

    @PostMapping("goods/save")
    void saveGoods(@RequestBody Goods goods);

    @DeleteMapping("goods/delete/{name}")
    void deleteGoodsByName(@PathVariable(name = "name") String name);

    @PutMapping("goods/update/{id}")
    void updateGoodsDescriptionById(@PathVariable(name = "id") Integer id, @RequestBody Goods newGoods);

}
