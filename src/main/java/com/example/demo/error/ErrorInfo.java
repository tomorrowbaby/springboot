package com.example.demo.error;

/**
 * 描述：错误信息
 * @author wangyu
 * @date 2019/5/17
 */

public class ErrorInfo<T> {

    public  static final Integer SUCCESS = 200 ;
    public  static final Integer ERROR = 100 ;

    private Integer code ;
    private String message ;
    private String url ;
    private T data ;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
