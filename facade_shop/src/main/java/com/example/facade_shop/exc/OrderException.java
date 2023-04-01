package com.example.facade_shop.exc;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderException extends RuntimeException {
    private final String message;
}
