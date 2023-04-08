package com.example.facade_goods.repository;

import com.example.facade_goods.domain.GoodsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GoodsRepository extends JpaRepository<GoodsEntity, Integer> {

    Optional<GoodsEntity> findByName(String name);

    void deleteByName(String name);
}
