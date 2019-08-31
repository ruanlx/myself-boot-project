package com.ruanlx.boot.model.response;

import com.ruanlx.boot.model.resultcode.IResultCode;
import lombok.*;

import java.util.Map;

/**
 * 普通对象POJO结果返回实体Reposonse
 * @author ruanlx
 * @ClassName DataResponse
 * @DateTime 2019/8/31 17:36
 * @Version 1.0
 */
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class DataResponse<T> extends BaseResponse {

    private static final long serialVersionUID = 5442916786536416743L;
    private T data;

    /**
     * 此处定义为private,只能通过warpSuccess，warpFail创建
     * @param success
     * @param code
     * @param message
     */
    private DataResponse(boolean success, String code, String message) {
        super(success, code, message);
    }

    /**
     * 返回成功的结果
     * @param data
     * @param <T>
     * @return
     */
    public static <T> DataResponse warpSuccess(T data) {
        DataResponse response = new DataResponse(true, BaseResponse.SUCCESS_CODE, BaseResponse.SUCCESS_MSG);
        response.setData(data);
        return response;
    }

    /**
     * 返回失败的结果
     * @param errCode
     * @param errMsg
     * @param <T>
     * @return
     */
    public static <T> DataResponse warpFail(String errCode, String errMsg) {
        DataResponse response = new DataResponse(false, errCode, errMsg);
        return response;
    }

    /**
     * 返回失败的结果
     * @param resultCode
     * @param <T>
     * @return
     */
    public static <T> DataResponse warpFail(IResultCode resultCode) {
        DataResponse response = new DataResponse(false, resultCode.getCode(), resultCode.getMessage());
        return response;
    }

    /**
     * 返回失败的结果, 附带错误返回数据
     * @param errCode
     * @param errMsg
     * @param errorData
     * @param <T>
     * @return
     */
    public static <T> DataResponse warpFail(String errCode, String errMsg, Map<String,Object> errorData) {
        DataResponse response = new DataResponse(false, errCode, errMsg);
        response.setErrorData(errorData);
        return response;
    }
}
