package com.example.demo.bean.audit;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BusinessAudit {
     private int id;
     private int user_id;
     private int admin_id;
     private Date createDate;
     private Date updateTime;
     private int state;
     private String certificates;
     
}
