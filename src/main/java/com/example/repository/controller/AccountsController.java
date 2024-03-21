package com.example.repository.controller;

import com.example.repository.common.Page;
import com.example.repository.entity.Accounts;
import com.example.repository.entity.Goods;
import com.example.repository.service.AccountsService;
import com.example.repository.service.InfoService;
import com.example.repository.vo.AccountsNumPrice;
import com.github.pagehelper.PageInfo;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountsController {

    @Resource
    private AccountsService accountsService;
    @Resource
    private InfoService infoService;

    @PostMapping("/outAndIn")
    public Integer outAndIn(@RequestBody Accounts accounts){
        accounts.setTime(LocalDateTime.now());
        if (accounts.getNumber()<0){
            accounts.setOperate("出库");
            //redis中添加消息
            infoService.add(accounts.getGoodsId(),accounts.getNumber());
        }else {
            accounts.setOperate("入库");
        }
        return accountsService.outAndIn(accounts);
    }

    @GetMapping("/selectOutAccounts")
    public Page selectOutAccounts(@RequestParam String goodsName,
                                   @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime date,
                                   @RequestParam(defaultValue = "1") Integer pageNum,
                                   @RequestParam(defaultValue = "10") Integer pageSize){
        PageInfo<Accounts> list=accountsService.selectOutAccounts(goodsName,date,pageNum,pageSize);
        return new Page(pageNum,pageSize,list.getPages(),list.getList());
    }

    @GetMapping("/selectById")
    public AccountsNumPrice selectById(@RequestParam Integer goodsId){
        return accountsService.selectById(goodsId);
    }
}
