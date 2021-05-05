package com.example.demo.bean.chat;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 聊天信息类
 * @author dy-xx
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Chat {
	private int chatId;
	private String toUser;
	private String fromUser;
	private String userContent;
	private Date crateDate;
}
