package com.itlinyi.schedule.common;

/**
 * @author 林一
 * @version 1.0
 */
public enum ResultCodeEnum {
    SUCCESS(200, "success"),

    USERNAME_ERROR(501,"usernameError"),

    PASSWORD_ERROR(503,"passwordError"),


    NOTLOGIN(504,"notLoggedIn"),
    USERNAME_USED(505,"usernameUsed"),;

    private Integer code;
    private String message;

    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
