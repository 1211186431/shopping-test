package com.example.demo.bean.goods;

import java.math.BigDecimal;

import com.example.demo.bean.seller.SellerInfo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GoodsShow {
    private int id;
    private BigDecimal price;
    private String name;
    private String picture;
}
