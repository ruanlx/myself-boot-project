package com.ruanlx.boot.model.response;

import com.ruanlx.boot.model.resultcode.IResultCode;
import com.ruanlx.boot.model.vo.PageInfoVO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

/**
 * 分页结果返回实体Reposonse
 * @author ruanlx
 * @ClassName PageResponse
 * @DateTime 2019/8/31 17:54
 * @Version 1.0
 */
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class PageResponse<T> extends BaseResponse {

    private PageInfoVO pageInfoVO;
    private List<T> data;

    /**
     * 此处定义为private,只能通过warpSuccess，warpFail创建
     * @param success
     * @param code
     * @param message
     */
    private PageResponse(boolean success, String code, String message) {
        super(success, code, message);
    }

    /**
     * 返回成功的结果
     * @param data
     * @param page
     * @param pageSize
     * @param <T>
     * @return
     */
    public static <T> PageResponse warpSuccess(List<T> data, int page, int pageSize) {
        PageResponse response = new PageResponse(true, BaseResponse.SUCCESS_CODE, BaseResponse.SUCCESS_MSG);
        response.setPageInfoVO(new PageInfoVO(page, pageSize, data == null ? 0 : data.size()));
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
    public static <T> PageResponse warpFail(String errCode, String errMsg) {
        PageResponse response = new PageResponse(false, errCode, errMsg);
        return response;
    }

    /**
     * 返回失败的结果
     * @param resultCode
     * @param <T>
     * @return
     */
    public static <T> PageResponse warpFail(IResultCode resultCode) {
        PageResponse response = new PageResponse(false, resultCode.getCode(), resultCode.getMessage());
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
    public static <T> PageResponse warpFail(String errCode, String errMsg, Map<String,Object> errorData) {
        PageResponse response = new PageResponse(false, errCode, errMsg);
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
    public static <T> PageResponse warpFail(IResultCode resultCode, Map<String,Object> errorData) {
        PageResponse response = new PageResponse(false, resultCode.getCode(), resultCode.getMessage());
        response.setErrorData(errorData);
        return response;
    }
}
