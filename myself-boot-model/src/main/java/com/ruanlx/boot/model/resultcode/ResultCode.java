package com.ruanlx.boot.model.resultcode;

/**
 * 结果码对象
 * @author ruanlx
 * @ClassName ResultCode
 * @DateTime 2019/8/31 20:16
 * @Version 1.0
 */
public class ResultCode implements IResultCode {

    private String systemCode;
    private String moduelCode;
    private String busCode;
    private String message;

    public ResultCode(String systemCode, String moduelCode, String busCode, String message) {
        this.systemCode = systemCode;
        this.moduelCode = moduelCode;
        this.busCode = busCode;
        this.message = message;
    }

    @Override
    public String getSystemCode() {
        return this.systemCode;
    }

    @Override
    public String getModuelCode() {
        return this.moduelCode;
    }

    @Override
    public String getBusCode() {
        return this.busCode;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
