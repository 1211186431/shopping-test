package com.example.demo.bean.goods;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GoodsPic {
  private int id;
  private int goodsId;
  private String picture;
}
