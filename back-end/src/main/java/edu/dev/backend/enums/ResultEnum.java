package edu.dev.backend.enums;

import lombok.Getter;

/**
 * Create By  @林俊杰
 * 2022/3/16 19:55
 *
 * @version 1.0
 */
@Getter
public enum ResultEnum {
    USER_LOGIN_ERROR(167,"请先登录"),

    IS_OK(200,"成功"),

    ERROR_MESSAGE(500,"内部服务器错误"),

    ERROR_MAP(501,"请求错误"),

    ERROR_TOKEN_MESSAGE(502,"token错误"),

    ERROR_UNKNOWN(555,"发生未知错误"),

    UNDEFINED_USER(201,"该用户尚未注册"),

    ERROR_PASSWORD(4402,"密码错误"),

    NULL_PARAM(409,"参数为空"),

    TIMEOUT(408,"超时")
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
