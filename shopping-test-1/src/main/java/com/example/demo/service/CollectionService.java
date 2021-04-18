package com.example.demo.service;

import java.util.ArrayList;

import com.example.demo.bean.collection.Collection;

public interface CollectionService {
     public ArrayList<Collection> getCollection(int userId);
     
     public int insertCollection(Collection c);
     
     public void deleteCollection(int id);
}
