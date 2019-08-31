package com.ruanlx.boot.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 请求Request基类
 * @author ruanlx
 * @ClassName BaseRequest
 * @DateTime 2019/8/31 19:07
 * @Version 1.0
 */
@Data
public class BaseRequest implements Serializable {

    private static final long serialVersionUID = 8975095734208465281L;

    /**
     * 全局唯一ID，用于日志定位
     */
    private String globalUniqueId;
}
