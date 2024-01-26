package edu.dev.backend.utils;

public class ResultVOUtil {

    public static ResultVO build(Integer status, String msg, Object data){
        return new ResultVO(status,msg,data);
    }

    public static ResultVO success(Object data) {
        return new ResultVO<Object>(200,"OK",data);
    }

    public static ResultVO success(){
        return success(null);
    }

    public static ResultVO errorMsg(String msg) {
        return new ResultVO(500, msg, null);
    }

    public static ResultVO errorMap(Object data) {
        return new ResultVO<Object>(501, "error", data);
    }

    public static ResultVO errorTokenMsg(String msg) {
        return new ResultVO(502, msg, null);
    }

    public static ResultVO errorException(String msg) {
        return new ResultVO(555, msg, null);
    }
}
