package com.example.demo.bean.goods;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 商品全部信息
 * @author dy-xx
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
	private int id;
	private int user_id;
	private int inventory;
	private int oldAndnew;
	private int state;
	private String details;
	private Date onsaleDate;
	private int bargain;
    private BigDecimal price;
    private String name;
    private String picture;
    private String delivery;
    private int salesNum;
    private double grade;
    private ArrayList<GoodsType> goodstype;
}
