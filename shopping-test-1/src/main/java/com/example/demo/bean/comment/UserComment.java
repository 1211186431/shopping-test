package com.example.demo.bean.comment;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 用户评论
 * @author dy-xx
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserComment {
     private int id;
     private int user_id;
     private int goods_id;
     private String content;
     private Date createDate;
     private int state;
     private double grade;
     private String orderNum;
}
