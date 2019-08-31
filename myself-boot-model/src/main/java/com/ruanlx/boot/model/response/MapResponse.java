package com.ruanlx.boot.model.response;

import com.ruanlx.boot.model.resultcode.IResultCode;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ruanlx
 * @ClassName MapResponse
 * @DateTime 2019/8/31 19:23
 * @Version 1.0
 */
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class MapResponse<K, V> extends BaseResponse {

    private Map<K, V> data;

    /**
     * 此处定义为private,只能通过warpSuccess，warpFail创建
     * @param success
     * @param code
     * @param message
     */
    public MapResponse(boolean success, String code, String message) {
        super(success, code, message);
    }

    /**
     * 灵活增加一组K,V
     * @param key
     * @param value
     * @return
     */
    public MapResponse<K, V> put(K key, V value) {
        if (data == null) {
            data = new HashMap<K, V>();
        }
        data.put(key, value);
        return this;
    }

    /**
     * 返回成功的结果
     * @param data
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> MapResponse warpSuccess(Map<K, V> data) {
        MapResponse response = new MapResponse(true, BaseResponse.SUCCESS_CODE, BaseResponse.SUCCESS_MSG);
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
    public static <T> MapResponse warpFail(String errCode, String errMsg) {
        MapResponse response = new MapResponse(false, errCode, errMsg);
        return response;
    }

    /**
     * 返回失败的结果
     * @param resultCode
     * @param <T>
     * @return
     */
    public static <T> MapResponse warpFail(IResultCode resultCode) {
        MapResponse response = new MapResponse(false, resultCode.getCode(), resultCode.getMessage());
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
    public static <T> MapResponse warpFail(String errCode, String errMsg, Map<String,Object> errorData) {
        MapResponse response = new MapResponse(false, errCode, errMsg);
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
    public static <T> MapResponse warpFail(IResultCode resultCode, Map<String,Object> errorData) {
        MapResponse response = new MapResponse(false, resultCode.getCode(), resultCode.getMessage());
        response.setErrorData(errorData);
        return response;
    }
}
