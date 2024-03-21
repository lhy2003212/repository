package com.example.repository.service;

import com.example.repository.entity.Goods;
import com.example.repository.mapper.GoodsMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsService {
    @Resource
    private GoodsMapper goodsMapper;
    public void add(Goods goods) {
        goodsMapper.add(goods);
    }

    public void delete(Integer id) {
        goodsMapper.delete(id);
    }

    public void updata(Goods goods) {
        goodsMapper.updata(goods);
    }

    public PageInfo<Goods> selectPage(String name, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Goods> list=goodsMapper.select(name);
        return PageInfo.of(list);
    }
}
