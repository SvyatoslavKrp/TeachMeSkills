package com.example.facade_shop.web;

import com.example.facade_shop.exc.OrderException;
import com.example.facade_shop.exc.ShopErrorDecoder;
import com.example.facade_shop.model.Goods;
import com.example.facade_shop.service.GoodsService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/shop")
@Tag(name = "orderController")
public class OrderController {

    private final GoodsService service;

    @GetMapping("/{name}")
    @ApiResponses(value = {
            @ApiResponse(description = "getGoodsByName", responseCode = "200", content = @Content(schema = @Schema(implementation = Goods.class))),
            @ApiResponse(description = "the name is empty", responseCode = "400", content = @Content(schema = @Schema(implementation = ShopErrorDecoder.class))),
            @ApiResponse(description = "there is no such goods", responseCode = "404", content = @Content(schema = @Schema(implementation = ShopErrorDecoder.class)))

    })
    public Goods getGoodsByName(@PathVariable(name = "name") String name) {
        return service.getGoodsByName(name);
    }

    @GetMapping
    @ApiResponses(
            @ApiResponse(description = "getAllGoods", content = @Content(schema = @Schema(implementation = List.class)))
    )
    public List<Goods> getAllGoods() {
        return service.getAllGoods();
    }

    @PostMapping("/save")
    @ApiResponses(value = {
            @ApiResponse(description = "saveGoods", responseCode = "200"),
            @ApiResponse(description = "the name is empty", responseCode = "400"),
    })
    public void saveGoods(@RequestBody Goods goods) {
        service.saveGoods(goods);
    }

    @DeleteMapping("/delete/{name}")
    @ApiResponses(value = {
            @ApiResponse(description = "deleteGoodsByName", responseCode = "200"),
            @ApiResponse(description = "the name is empty", responseCode = "400", content = @Content(schema = @Schema(implementation = ShopErrorDecoder.class))),
            @ApiResponse(description = "there is no such goods", responseCode = "404", content = @Content(schema = @Schema(implementation = ShopErrorDecoder.class)))
    })
    public void deleteGoodsByName(@PathVariable(name = "name") String name) {
        service.deleteGoodsByName(name);
    }

    @PutMapping("/update/{id}")
    @ApiResponses(value = {
            @ApiResponse(description = "updateGoodsById", responseCode = "200"),
            @ApiResponse(description = "the name is empty", responseCode = "400", content = @Content(schema = @Schema(implementation = ShopErrorDecoder.class))),
            @ApiResponse(description = "there is no such goods", responseCode = "404", content = @Content(schema = @Schema(implementation = ShopErrorDecoder.class)))
    })
    public void updateGoodsById(@PathVariable Integer id, @RequestBody Goods newGoods) {
        service.updateGoodsDescriptionById(id, newGoods);
    }

    @ExceptionHandler
    public ResponseEntity<String> orderExcRequest(OrderException exception) {
        return ResponseEntity.status(404).body(exception.getMessage());
    }

}
