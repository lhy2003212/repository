package com.example.repository.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Data
public class Accounts {
    @Resource
    private Integer id;
    @Resource
    private Integer goodsId;
    @Resource
    private Integer number;
    @Resource
    private Integer storeId;

    @Resource
    private String operate;

    @Resource
    @JsonFormat
    private LocalDateTime time;
}
