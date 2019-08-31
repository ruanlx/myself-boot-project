package com.ruanlx.boot.model.resultcode;

/**
 * 系统层面异常错误码
 * @author ruanlx
 * @ClassName SystemResultCode
 * @DateTime 2019/8/31 20:32
 * @Version 1.0
 */
public interface SystemResultCode {
    ResultCodeFactory RCF = new ResultCodeFactory("000", "00");

    IResultCode SYSTM_SOCKET_ERROR = RCF.builder("001", "系统网络异常");
    IResultCode SYSTM_FRAMEWORK_ERROR = RCF.builder("002", "系统框架异常");
    IResultCode SYSTM_MEMOERY_ERROR = RCF.builder("002", "系统内存异常");
    IResultCode SYSTM_THREAD_ERROR = RCF.builder("004", "系统线程异常");
    IResultCode SYSTM_DATABASE_ERROR = RCF.builder("001", "系统数据库异常");
}
