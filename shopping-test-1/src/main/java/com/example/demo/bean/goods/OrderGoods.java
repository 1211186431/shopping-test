package com.example.demo.bean.goods;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderGoods {
   private int id;
   private String orderNumber;
   private int goodsId;
   private int goodsNum;
   private int state;
   private String name;
   private BigDecimal price;
   private String picture;
}
