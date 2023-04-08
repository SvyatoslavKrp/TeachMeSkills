package com.example.facade_goods.web;

import com.example.facade_goods.dto.GoodsDto;
import com.example.facade_goods.exc.NoSuchGoodsException;
import com.example.facade_goods.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/goods")
public class GoodsResource {

    private final GoodsService service;

    @GetMapping("/{name}")
    public GoodsDto getGoodsByName(@PathVariable(name = "name") String name) {
        return service.getGoodsByName(name);
    }

    @GetMapping
    public List<GoodsDto> getAllGoods() {
        return service.getAllGoods();
    }

    @PostMapping("/save")
    public void saveGoods(@RequestBody @Valid GoodsDto goods) {
        service.saveGoods(goods);
    }

    @DeleteMapping("/delete/{name}")
    public void deleteGoodsByName(@PathVariable(name = "name") String name) {
        service.deleteGoodsByName(name);
    }

    @PutMapping("/update/{id}")
    public void updateGoodsById(@PathVariable Integer id, @RequestBody @Valid GoodsDto newGoods) {
        service.updateGoodsById(id, newGoods);
    }

    @ExceptionHandler
    public ResponseEntity<String> noSuchGoods(NoSuchGoodsException exc) {
        return ResponseEntity.status(404).body(exc.getMessage());
    }

}
