package com.ruanlx.boot.model.response;

import lombok.*;

import java.io.Serializable;
import java.util.Map;

/**
 * 服务返回的基础类，通过success判断服务是否成功
 * @author ruanlx
 * @ClassName BaseResponse
 * @DateTime 2019/8/31 17:20
 * @Version 1.0
 */
@Getter
@ToString
@EqualsAndHashCode
public class BaseResponse implements Serializable {

    private static final long serialVersionUID = -7715595744814721087L;
    public static final String SUCCESS_CODE = "000";
    public static final String SUCCESS_MSG = "成功";
    /**
     * 服务返回是否成功
     */
    private boolean success;
    /**
     * 服务返回码
     */
    private String code;
    /**
     * 服务返回信息
     */
    private String message;
    /**
     * 错误数据Map
     */
    @Setter
    private Map<String, Object> errorData;

    /**
     * 全局唯一ID，用于日志定位
     */
    @Setter
    private String globalUniqueId;

    public BaseResponse(boolean success, String code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}
