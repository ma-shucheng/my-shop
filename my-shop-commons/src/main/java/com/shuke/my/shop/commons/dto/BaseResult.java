package com.shuke.my.shop.commons.dto;

import java.io.Serializable;

/**
 * 
 * <p>
 * 自定义返回结果
 * </p>
 * 
 * @author shuke
 * @version v1.0.0
 * @since 2020-03-01 17:58:51
 * @see com.shuke.my.shop.commons.dto
 *
 */
public class BaseResult implements Serializable {
    //针对常量要定义设置常量
    public static final int STATUS_SUCCESS = 200;
    public static final int STATUS_FAIL = 500;

    private int status;
    private String message;

    /**
     * 返回成功信息
     * @return
     */
    public static BaseResult success() {
        return createResult(STATUS_SUCCESS,"成功");
    }

    /**
     * 自定义返回成功
     * @param message
     * @return
     */
    public static BaseResult success(String message) {
        return createResult(STATUS_SUCCESS,message);
    }

    /**
     * 返回失败信息
     * @return
     */
    public static BaseResult fail() {
        return createResult(STATUS_FAIL,"失败");
    }

    /**
     * 自定义返回信息
     * @param message
     * @return
     */
    public static BaseResult fail(String message) {
        return createResult(STATUS_FAIL,message);
    }

    /**
     * 因为失败状态有多种还应该设置不同的状态码
     * @param status
     * @param message
     * @return
     */
    public static BaseResult fail(int status, String message) {
        return createResult(status, message);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 返回状态信息
     * @param status
     * @param message
     * @return
     */
    private static BaseResult createResult(int status,String message) {
        BaseResult baseResult = new BaseResult();
        baseResult.setStatus(status);
        baseResult.setMessage(message);
        return baseResult;
    }
}
