package com.example.demo.bean.collection;

import java.math.BigDecimal;
import java.util.Date;

import com.example.demo.bean.goods.Goods;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Collection {
    private int id;
    private int user_id;
    private int goods_id;
    private Date createDate;
}
