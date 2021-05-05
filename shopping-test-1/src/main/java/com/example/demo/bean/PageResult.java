package com.example.demo.bean;

import java.util.List;

import lombok.Data;
/**
 * 分页
 * @author dy-xx
 *
 * @param <T>
 */
@Data
public class PageResult<T> {
    /**
     * 当前页码
     */
    private int pageNum;
    /**
     * 每页数量
     */
    private int pageSize;
    /**
     * 记录总数
     */
    private long totalSize;
    /**
     * 页码总数
     */
    private int totalPages;
    /**
     * 数据模型
     */
    private List<T> data;
}
