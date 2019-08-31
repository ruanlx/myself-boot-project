package com.ruanlx.boot.model.exception;

import com.ruanlx.boot.model.resultcode.IResultCode;
import lombok.Getter;

/**
 * 校验异常
 * @author ruanlx
 * @ClassName ValidationException
 * @DateTime 2019/8/31 20:08
 * @Version 1.0
 */
public class ValidationException extends Exception {

    @Getter
    private final IResultCode resultCode;

    public ValidationException(IResultCode resultCode) {
        super(resultCode.getMessage());
        this.resultCode = resultCode;
    }

    public ValidationException(IResultCode resultCode, String message) {
        super(message);
        this.resultCode = resultCode;
    }

    @Override
    public String toString() {
        return "ValidationException{" +
                "resultCode=" + resultCode.getCode() +
                "message=" + resultCode.getMessage() +
                '}';
    }
}
