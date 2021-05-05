package com.example.demo.bean.goods;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 订单详细信息（数据库存储）
 * @author dy-xx
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {
	private String orderNumber;
    private int user_id;
    private BigDecimal Allprice;
    private Date purchasingDate;
    private String receiver;
    private String payment;
    private int state;
}
