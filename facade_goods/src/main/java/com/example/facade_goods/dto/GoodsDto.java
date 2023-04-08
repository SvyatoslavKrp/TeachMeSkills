package com.example.facade_goods.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Data
public class GoodsDto {

    private Integer id;
    @NotBlank
    private String name;
    private String description;

}
