package com.example.facade_goods.service.impl;

import com.example.facade_goods.domain.GoodsEntity;
import com.example.facade_goods.dto.GoodsDto;
import com.example.facade_goods.exc.NoSuchGoodsException;
import com.example.facade_goods.mapper.GoodsMapper;
import com.example.facade_goods.repository.GoodsRepository;
import com.example.facade_goods.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor

@Service
public class GoodsServiceImpl implements GoodsService {

    private final GoodsRepository repository;
    private final GoodsMapper mapper;

    @PostConstruct
    public void init() {
        GoodsEntity goods1 = new GoodsEntity("book", "forReading");
        GoodsEntity goods2 = new GoodsEntity("pen", "forWriting");
        GoodsEntity goods3 = new GoodsEntity("pencil", null);
        repository.save(goods1);
        repository.save(goods2);
        repository.save(goods3);

    }


    @Override
    public GoodsDto getGoodsByName(String name) {
        return repository.findByName(name)
                .map(mapper::toDto)
                .orElseThrow(NoSuchGoodsException::new);
    }

    @Override
    public List<GoodsDto> getAllGoods() {
        List<GoodsEntity> allGoods = repository.findAll();
        return mapper.listToDto(allGoods);
    }

    @Override
    public void saveGoods(GoodsDto goods) {
        GoodsEntity goodsEntity = mapper.toEntity(goods);
        repository.save(goodsEntity);
    }

    @Override
    @Transactional
    public void deleteGoodsByName(String name) {
        getGoodsByName(name);
        repository.deleteByName(name);
    }

    @Override
    @Transactional
    public void updateGoodsById(Integer id, GoodsDto newGoods) {
        Optional<GoodsEntity> byId = Optional
                .ofNullable(repository.findById(id)
                        .orElseThrow(NoSuchGoodsException::new));
        if (byId.isPresent()) {

            GoodsEntity goodsFromDB = byId.get();
            mapper.updateGoodsFromDto(newGoods, goodsFromDB);

        }
    }
}
