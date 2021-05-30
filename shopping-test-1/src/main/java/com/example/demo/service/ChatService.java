package com.example.demo.service;

import java.util.ArrayList;

import com.example.demo.bean.chat.Chat;

public interface ChatService {
	/**
	 * 保存聊天
	 * @param c
	 */
    public void insertChat(Chat c);
    
    /**
     * 获取聊天记录
     * @param fromUser
     * @param toUser
     * @return
     */
    public ArrayList<Chat> getUserChat(String fromUser,String toUser);
}
