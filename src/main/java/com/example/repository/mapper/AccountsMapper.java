package com.example.repository.mapper;

import com.example.repository.entity.Accounts;

import java.time.LocalDateTime;
import java.util.List;

public interface AccountsMapper{
   void add(Accounts accounts);

    //统计某商品在指定门店的数量,当门店id空时，返回指定商品所有库存数量
    Integer selectNumber(Integer goodsId, Integer storeId);

    List<Accounts> selectOutAccounts(String goodsName, LocalDateTime date);
}
