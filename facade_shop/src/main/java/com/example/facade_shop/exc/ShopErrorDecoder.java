package com.example.facade_shop.exc;

import feign.Response;
import feign.codec.ErrorDecoder;

public class ShopErrorDecoder implements ErrorDecoder {


    @Override
    public Exception decode(String methodKey, Response response) {
        int status = response.status();
        switch (status) {
            case 404:
                return new OrderException("there is no such goods");
            case 400:
                return new OrderException("the name is empty");
            default:
                throw new RuntimeException("an error is unknown");

        }
    }
}
