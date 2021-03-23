package com.xu.jetpacklearn.base;

/**
 * @Author 许剑波
 * 创建时间：2021/3/23  17:42
 * 类的功能：通用response
 */
public class BaseResponse<T> {

    private Integer code;

    private String message;

    private T result;

    private Boolean success;

    private Long timestamp;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
