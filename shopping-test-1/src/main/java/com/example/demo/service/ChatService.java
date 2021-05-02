package com.example.demo.service;

import java.util.ArrayList;

import com.example.demo.bean.chat.Chat;

public interface ChatService {
    public void insertChat(Chat c);
    
    public ArrayList<Chat> getUserChat(String fromUser,String toUser);
}
