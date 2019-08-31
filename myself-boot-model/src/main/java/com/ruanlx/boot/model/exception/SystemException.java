package com.ruanlx.boot.model.exception;

import com.ruanlx.boot.model.resultcode.IResultCode;
import lombok.Getter;

/**
 * 系统异常
 * @author ruanlx
 * @ClassName SystemException
 * @DateTime 2019/8/31 16:48
 * @Version 1.0
 */
public class SystemException extends Exception {

    @Getter
    private final IResultCode resultCode;

    public SystemException(IResultCode resultCode) {
        super(resultCode.getMessage());
        this.resultCode = resultCode;
    }

    public SystemException(IResultCode resultCode, String message) {
        super(message);
        this.resultCode = resultCode;
    }

    @Override
    public String toString() {
        return "SystemException{" +
                "resultCode=" + resultCode.getCode() +
                "message=" + resultCode.getMessage() +
                '}';
    }
}
