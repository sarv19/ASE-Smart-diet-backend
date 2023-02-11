package com.group42.model.to;

import lombok.Data;

@Data
public class BaseTO {

    /**
     * 当前记录起始索引
     */
    private Integer pageNum;

    /**
     * 每页显示记录数
     */
    private Integer pageSize;

}
