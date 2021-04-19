package com.example.demo.bean.goods;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import com.example.demo.helper.GoodsUtil;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderR {
	  private String orderNumber;
      private int userId;
      private BigDecimal Allprice;
      private Date purchasingDate;
      private String receiver;
      private String payment;
      private int state;
      private ArrayList<GoodsUtil> goodsList;
}
