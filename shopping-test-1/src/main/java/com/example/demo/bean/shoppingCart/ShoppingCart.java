package com.example.demo.bean.shoppingCart;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 购物车类
 * @author dy-xx
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCart {
   private int id;
   private int userId;
   private int goodsId;
   private int goodsNum;
}
