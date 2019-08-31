package com.ruanlx.boot.model.resultcode;

/**
 * 结果码
 * @ClassName: IResultCode
 * @author: ruanlx
 * @DateTime: 2019/8/31 20:12
 * @Version: 1.0
 */
public interface IResultCode {
    /**
     * 获取系统码
     * @return
     */
    String getSystemCode();

    /**
     * 获取模块码
     * @return
     */
    String getModuelCode();

    /**
     * 获取业务码
     * @return
     */
    String getBusCode();

    /**
     * 获取信息描述
     * @return
     */
    String getMessage();

    default String getCode() {
        return getSystemCode() + getModuelCode() + getBusCode();
    }
}
