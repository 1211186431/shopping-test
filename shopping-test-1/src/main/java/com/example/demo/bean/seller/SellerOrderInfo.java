package com.example.demo.bean.seller;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SellerOrderInfo {
    private String orderNumber;
    private Date purchasingDate;
    private int goodsId;
    private int goodsNum;
    private int sellerId;
    private int userId;
    
}
