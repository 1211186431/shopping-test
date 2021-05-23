package com.example.demo.bean.seller;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 商家查看订单（多表连接结果）
 * @author dy-xx
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SellerOrderInfo {
	private int id;
    private String orderNumber;
    private Date purchasingDate;
    private int goodsId;
    private int goodsNum;
    private int sellerId;
    private int userId;
    private int state;
    private int receiver;
    
}
