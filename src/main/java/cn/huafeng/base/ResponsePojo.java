package cn.huafeng.base;

import cn.huafeng.enums.ResponseEnum;

/**
 *    biz调用返回response对象，将响应码，响应信息，响应对象给封装
 * @param <T>
 */
public class ResponsePojo<T> {

    private String code;//响应吗
    private String message;//响应信息
    private T object;//成功返回对象，否则返回Null

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public T getObject() {
        return object;
    }
    public void setObject(T object) {
        this.object = object;
    }

    public ResponsePojo(){}
    public ResponsePojo(ResponseEnum responseCodeType){
        this.code = responseCodeType.getCode();
        this.message=responseCodeType.getDisplayName();
    }
    public ResponsePojo(String code,String message){
        this.code=code;
        this.message =message;
    }
    public ResponsePojo(String code,String message,T object){
        this.code=code;
        this.message =message;
        this.object=object;
    }
    public ResponsePojo(ResponseEnum responseCodeType,T object){
        this.code=responseCodeType.getCode();
        this.message =responseCodeType.getDisplayName();
        this.object=object;
    }
}
