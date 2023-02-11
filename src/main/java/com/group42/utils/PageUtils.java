package com.group42.utils;

import com.github.pagehelper.PageHelper;
import com.group42.model.to.BaseTO;

public class PageUtils extends PageHelper {

    /**
     * 设置请求分页数据
     */
    public static void startPage(BaseTO baseTO) {
        if(null == baseTO) {
            PageHelper.startPage(1, 10).setReasonable(true);
        } else {
            PageHelper.startPage(Convert.toInt(baseTO.getPageNum(), 1), Convert.toInt(baseTO.getPageSize(), 10)).setReasonable(true);
        }
    }

}
