package com.ruanlx.boot.model.request;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ruanlx
 * @ClassName PageRequest
 * @DateTime 2019/8/31 19:36
 * @Version 1.0
 */
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class PageRequest extends BaseRequest {

    private static final long serialVersionUID = -6155750759441733901L;

    /**
     * 页码，默认为 1
     */
    private int page = 1;
    /**
     * 分页大小，默认为 10
     */
    private int pageSize = 10;
}
