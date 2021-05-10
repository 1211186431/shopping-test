package com.example.demo.helper;




import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 订单辅助类
 * @author dy-xx
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GoodsUtil {
   private int goodsId;
   private int goodsNum;
}
