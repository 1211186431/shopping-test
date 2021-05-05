package com.example.demo.bean.goods;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 商品图片类
 * @author dy-xx
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GoodsPic {
  private int id;
  private int goodsId;
  private String picture;
}
