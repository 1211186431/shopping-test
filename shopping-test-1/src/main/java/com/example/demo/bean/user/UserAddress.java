package com.example.demo.bean.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户收货地址
 * @author dy-xx
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAddress {
    private int id;
    private int userId;
    private String address;
    private String phone;
    private String receiver;
}
