package com.ruanlx.boot.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 分页对象信息
 * @author ruanlx
 * @ClassName pageInfo
 * @DateTime 2019/8/31 19:11
 * @Version 1.0
 */
@Data
public class PageInfoVO implements Serializable {
    private static final long serialVersionUID = -2874687029266571862L;
    private int page;
    private int pageSize = 10;
    private int totalCount;
    private int totalPage;
    public PageInfoVO(int page, int pageSize, int totalCount) {
        this.page = page;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPage = totalCount / pageSize;
    }
}
