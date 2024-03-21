package com.example.repository.entity;

import lombok.Data;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Data
public class Goods {
    @Resource
    private Integer id;

    @Resource
    private String name;

    @Resource
    private Integer price;

    @Resource
    private String attribute;
    @Resource
    private LocalDateTime wtime;
}
