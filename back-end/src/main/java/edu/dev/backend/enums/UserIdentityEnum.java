package edu.dev.backend.enums;

import lombok.Getter;

/**
 * Create By  @林俊杰
 * 2022/3/28 12:01
 *
 * @version 1.0
 */
@Getter
public enum UserIdentityEnum {

    VISITOR(0,"游客"),

    NORMAL(1,"普通用户"),

    EMPLOYEE(2,"工作人员")

    ;

    private Integer code;

    private String message;

    UserIdentityEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
