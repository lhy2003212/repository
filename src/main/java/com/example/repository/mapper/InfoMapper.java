package com.example.repository.mapper;

import com.example.repository.entity.Info;

import java.time.LocalDateTime;
import java.util.List;

public interface InfoMapper {
    List<Info> selectList(LocalDateTime beforInTime, LocalDateTime afterInTime);

    void add(Info info);

    void read(Integer id);
}
