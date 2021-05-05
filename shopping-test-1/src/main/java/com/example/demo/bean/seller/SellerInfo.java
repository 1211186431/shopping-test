package com.example.demo.bean.seller;


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
   
    private int userId;
    private int score;
    private int state;
    
}
