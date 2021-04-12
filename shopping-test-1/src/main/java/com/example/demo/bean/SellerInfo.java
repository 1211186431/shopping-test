package com.example.demo.bean;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 卖家类
 * @author dy-xx
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SellerInfo {
   
    private int user_id;
    private int score;
    private int state;
    
}
