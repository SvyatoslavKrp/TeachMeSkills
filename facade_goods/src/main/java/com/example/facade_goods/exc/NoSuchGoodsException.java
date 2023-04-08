package com.example.facade_goods.exc;

import lombok.Getter;

@Getter
public class NoSuchGoodsException extends RuntimeException {
    private final String message = "there is no such goods";
}
