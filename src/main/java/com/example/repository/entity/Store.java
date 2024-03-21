package com.example.repository.entity;


import lombok.Data;

import javax.annotation.Resource;

@Data
public class Store {
    @Resource
    private Integer id;
    @Resource
    private String name;
    @Resource
    private String address;
}
