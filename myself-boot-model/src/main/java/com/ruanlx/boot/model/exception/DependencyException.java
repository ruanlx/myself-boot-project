package com.ruanlx.boot.model.exception;

import com.ruanlx.boot.model.resultcode.IResultCode;
import lombok.Getter;

/**
 * 服务依赖调用异常
 * @author ruanlx
 * @ClassName DependencyException
 * @DateTime 2019/8/31 20:09
 * @Version 1.0
 */
public class DependencyException extends Exception {

    @Getter
    private final IResultCode resultCode;

    public DependencyException(IResultCode resultCode) {
        super(resultCode.getMessage());
        this.resultCode = resultCode;
    }

    public DependencyException(IResultCode resultCode, String message) {
        super(message);
        this.resultCode = resultCode;
    }

    @Override
    public String toString() {
        return "DependencyException{" +
                "resultCode=" + resultCode.getCode() +
                "message=" + resultCode.getMessage() +
                '}';
    }
}
