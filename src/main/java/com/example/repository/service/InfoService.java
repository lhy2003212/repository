package com.example.repository.service;

import com.example.repository.entity.Info;
import com.example.repository.mapper.InfoMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class InfoService {
    @Resource
    private InfoMapper infoMapper;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public PageInfo<Info> selectList(LocalDateTime beforInTime, LocalDateTime afterInTime, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Info> list=infoMapper.selectList(beforInTime,afterInTime);
        return PageInfo.of(list);
    }

    public void add(Integer goodsId,Integer number) {
        Info info = new Info();
        info.setOutTime(LocalDateTime.now());
        info.setReadStatus("未读");
        info.setContent("商品编号："+goodsId+"出库"+"number");
        infoMapper.add(info);
        stringRedisTemplate.opsForValue().set(info.getId().toString(),info.getContent());
        stringRedisTemplate.expire(info.getId().toString(), Duration.ofSeconds(30));
    }

    public void read(Integer id) {
        infoMapper.read(id);
    }
}
