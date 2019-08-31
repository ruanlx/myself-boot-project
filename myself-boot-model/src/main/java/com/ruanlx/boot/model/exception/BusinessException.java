package com.ruanlx.boot.model.exception;

import com.ruanlx.boot.model.resultcode.IResultCode;
import lombok.Getter;

/**
 * 系统业务异常
 * @author ruanlx
 * @ClassName BusinessException
 * @DateTime 2019/8/31 20:02
 * @Version 1.0
 */
public class BusinessException extends Exception {

    @Getter
    private final IResultCode resultCode;

    public BusinessException(IResultCode resultCode) {
        super(resultCode.getMessage());
        this.resultCode = resultCode;
    }

    public BusinessException(IResultCode resultCode, String message) {
        super(message);
        this.resultCode = resultCode;
    }

    @Override
    public String toString() {
        return "BusinessException{" +
                "resultCode=" + resultCode.getCode() +
                "message=" + resultCode.getMessage() +
                '}';
    }
}
