package com.ruanlx.boot.model.response;

import com.ruanlx.boot.model.resultcode.IResultCode;
import lombok.*;

import java.util.List;
import java.util.Map;

/**
 * List 结果返回实体Reposonse
 * @author ruanlx
 * @ClassName ListResponse
 * @DateTime 2019/8/31 17:48
 * @Version 1.0
 */
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ListResponse<T> extends BaseResponse {

    private static final long serialVersionUID = 4204092837822558709L;

    private List<T> data;

    /**
     * 此处定义为private,只能通过warpSuccess，warpFail创建
     * @param success
     * @param code
     * @param message
     */
    private ListResponse(boolean success, String code, String message) {
        super(success, code, message);
    }

    /**
     * 返回成功的结果
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ListResponse warpSuccess(List<T> data) {
        ListResponse response = new ListResponse(true, BaseResponse.SUCCESS_CODE, BaseResponse.SUCCESS_MSG);
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
    public static <T> ListResponse warpFail(String errCode, String errMsg) {
        ListResponse response = new ListResponse(false, errCode, errMsg);
        return response;
    }

    /**
     * 返回失败的结果
     * @param resultCode
     * @param <T>
     * @return
     */
    public static <T> ListResponse warpFail(IResultCode resultCode) {
        ListResponse response = new ListResponse(false, resultCode.getCode(), resultCode.getMessage());
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
    public static <T> ListResponse warpFail(String errCode, String errMsg, Map<String,Object> errorData) {
        ListResponse response = new ListResponse(false, errCode, errMsg);
        response.setErrorData(errorData);
        return response;
    }

    /**
     * 返回失败的结果, 附带错误返回数据
     * @param resultCode
     * @param errorData
     * @param <T>
     * @return
     */
    public static <T> ListResponse warpFail(IResultCode resultCode, Map<String,Object> errorData) {
        ListResponse response = new ListResponse(false, resultCode.getCode(), resultCode.getMessage());
        response.setErrorData(errorData);
        return response;
    }
}
