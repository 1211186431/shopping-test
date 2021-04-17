package com.example.demo.bean.comment;

import java.util.Date;

import com.example.demo.bean.SellerInfo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserComment {
     private int id;
     private int user_id;
     private int seller_id;
     private String content;
     private Date createDate;
     private int state;
     private double grade;
}
