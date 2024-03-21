package com.example.repository.service;


import com.example.repository.entity.Accounts;
import com.example.repository.entity.Goods;
import com.example.repository.mapper.AccountsMapper;
import com.example.repository.mapper.GoodsMapper;
import com.example.repository.mapper.InfoMapper;
import com.example.repository.vo.AccountsNumPrice;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AccountsService {

    @Resource
    private AccountsMapper accountsMapper;
    @Resource
    private GoodsMapper goodsMapper;
    @Resource
    private InfoService infoService;

    public void add(Accounts accounts) {
        accountsMapper.add(accounts);
        infoService.add(accounts.getGoodsId(),accounts.getNumber());
    }

    public Integer outAndIn(Accounts accounts){
        this.add(accounts);
        return this.selectNumber(accounts.getGoodsId(), accounts.getStoreId());
    }

    //统计某商品在指定门店的数量,当门店id空时，返回指定商品所有库存数量
    private Integer selectNumber(Integer goodsId,Integer storeId){
        return accountsMapper.selectNumber(goodsId,storeId);
    }

    public PageInfo<Accounts> selectOutAccounts(String goodsName, LocalDateTime date, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Accounts> list=accountsMapper.selectOutAccounts(goodsName,date);
        return PageInfo.of(list);
    }

    public AccountsNumPrice selectById(Integer goodsId) {
        AccountsNumPrice accountsNumPrice = new AccountsNumPrice();
        accountsNumPrice.setNumber(this.selectNumber(goodsId,null));
        accountsNumPrice.setPrice(goodsMapper.selectById(goodsId).getPrice());
        return accountsNumPrice;
    }
}
