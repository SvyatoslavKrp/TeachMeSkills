package com.example.facade_shop.config;

import com.example.facade_shop.exc.ShopErrorDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FeignConfiguration {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new ShopErrorDecoder();
    }

}
