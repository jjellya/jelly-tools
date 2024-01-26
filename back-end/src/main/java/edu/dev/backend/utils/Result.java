package edu.dev.backend.utils;

import edu.dev.backend.enums.ResultEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

//统一返回结果的类
@Data
public class Result {


    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<String, Object>();

    //把构造方法私有
    private Result() {}

    //成功静态方法
    public static Result success() {
        Result r = new Result();
        r.setCode(ResultEnum.IS_OK.getCode());
        r.setMessage(ResultEnum.IS_OK.getMessage());
        return r;
    }

    //成功码200静态方法
    public static Result success200(String messageParam) {
        Result r = new Result();
        r.setCode(ResultEnum.IS_OK.getCode());
        r.setMessage(messageParam);
        return r;
    }

    public static Result OK2Object(String key,Object value) {
        Result r = new Result();
        r.setCode(ResultEnum.IS_OK.getCode());
        r.setMessage("OK");
        r.data(key, value);
        return r;
    }

    //失败静态方法
    public static Result error() {
        Result r = new Result();
        r.setCode(ResultEnum.ERROR_MAP.getCode());
        r.setMessage(ResultEnum.ERROR_MAP.getMessage());
        return r;
    }

    public static Result errorMsg(String msg) {
        Result r = new Result();
        r.setCode(ResultEnum.ERROR_MAP.getCode());
        r.setMessage(msg);
        return r;
    }


    public Result message(String message){
        this.setMessage(message);
        return this;
    }

    public Result code(Integer code){
        this.setCode(code);
        return this;
    }

    public Result data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    public Result data(Map<String, Object> map){
        this.setData(map);
        return this;
    }
}
