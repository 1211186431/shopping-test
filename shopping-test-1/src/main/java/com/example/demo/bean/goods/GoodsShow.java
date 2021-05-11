package com.example.demo.bean.goods;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 向前端传送的商品展示信息
 * @author dy-xx
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GoodsShow {
    private int id;
    private BigDecimal price;
    private String name;
    private String picture;
    private int user_id;
}
