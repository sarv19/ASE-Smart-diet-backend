package com.group42.utils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.group42.model.bean.R;
import com.group42.model.to.BaseTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageUtils extends PageHelper {

    public static void startPage(BaseTO baseTO) {
        if (null == baseTO) {
            PageHelper.startPage(1, 10).setReasonable(true);
        } else {
            PageHelper.startPage(Convert.toInt(baseTO.getPageNum(), 1), Convert.toInt(baseTO.getPageSize(), 10)).setReasonable(true);
        }
    }

    public static Map<String, Object> pageInfoMap(Object pageData) {
        Map<String, Object> map = new HashMap<>();
        if (pageData instanceof PageInfo) map.put(R.DATA_TAG, pageData);
        else if (pageData instanceof List<?>) map.put(R.DATA_TAG, new PageInfo<>((List<?>) pageData));
        else map.put(R.DATA_TAG, new PageInfo<>());
        return map;
    }

}
