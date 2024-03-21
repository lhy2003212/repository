package com.example.repository.controller;

import com.example.repository.common.Page;
import com.example.repository.entity.Goods;
import com.example.repository.service.GoodsService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Resource
    private GoodsService goodsService;

    @PostMapping("/add")
    public void add(@RequestBody Goods goods){
        goods.setWtime(LocalDateTime.now());
        goodsService.add(goods);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        goodsService.delete(id);

    }
    @PutMapping("/updata")
    public void updata(@RequestBody Goods goods){
        goodsService.updata(goods);
    }

    @GetMapping("/selectPage")
    public Page selectPage(@RequestParam String name,
                            @RequestParam(defaultValue = "1") Integer pageNum,
                            @RequestParam(defaultValue = "10") Integer pageSize){
        PageInfo<Goods> goodsPageInfo = goodsService.selectPage(name, pageNum, pageSize);
        return new Page(pageNum,pageSize,goodsPageInfo.getPages(),goodsPageInfo.getList());
    }
}
