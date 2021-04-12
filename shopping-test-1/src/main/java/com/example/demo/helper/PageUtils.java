package com.example.demo.helper;

import com.example.demo.bean.PageResult;
import com.github.pagehelper.PageInfo;
public class PageUtils {
    /**
     * 将分页信息封装到统一的接口
     *
     * @param pageInfo
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static PageResult<?> getPageResult(PageInfo<?> pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setData(pageInfo.getList());
        
        return pageResult;
    }
}
