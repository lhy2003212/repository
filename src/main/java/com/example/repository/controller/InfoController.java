package com.example.repository.controller;

import com.example.repository.common.Page;
import com.example.repository.entity.Accounts;
import com.example.repository.entity.Info;
import com.example.repository.service.InfoService;
import com.github.pagehelper.PageInfo;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/info")
public class InfoController {
    @Resource
    private InfoService infoService;

    @GetMapping("/selectList")
    public Page selectList(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime beforInTime,
                           @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime afterInTime,
                           @RequestParam(defaultValue = "1") Integer pageNum,
                           @RequestParam(defaultValue = "10") Integer pageSize){
        PageInfo<Info> list = infoService.selectList(beforInTime, afterInTime, pageNum, pageSize);
        return new Page(pageNum,pageSize,list.getPages(),list.getList());
    }

    @GetMapping("/read/{id}")
    public void read(@PathVariable Integer id){
        infoService.read(id);
    }

    //添加消息{
    //添加消息，设置数据
    //}

    //从redis获取信息列表

    //当点击消息时，修改对应消息阅读状态



}
