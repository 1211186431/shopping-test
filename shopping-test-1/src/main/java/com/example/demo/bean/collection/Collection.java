package com.example.demo.bean.collection;

import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 收藏类
 * @author dy-xx
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Collection {
    private int id;
    private int user_id;
    private int goods_id;
    private Date createDate;
    private BigDecimal price;
    private String name;
    private String picture;
}
