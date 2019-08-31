package com.ruanlx.boot.model.resultcode;

/**
 * @author ruanlx
 * @ClassName ResultCodeFactory
 * @DateTime 2019/8/31 20:19
 * @Version 1.0
 */
public class ResultCodeFactory {

    private String systemCode;
    private String moduelCode;

    public ResultCodeFactory(String systemCode, String moduelCode) {
        this.systemCode = systemCode;
        this.moduelCode = moduelCode;
    }

    /**
     * 创建结果码 ResultCode
     * @param busCode
     * @param message
     * @return
     */
    public ResultCode builder(String busCode, String message) {
        return new ResultCode(systemCode, moduelCode, busCode, message);
    }
}
