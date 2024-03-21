package com.example.repository.mapper;

import com.example.repository.entity.Goods;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface GoodsMapper {
    void add(Goods goods);

    void delete(Integer id);

    void updata(Goods goods);

    List<Goods> select(String name);

    Goods selectById(Integer id);
}
