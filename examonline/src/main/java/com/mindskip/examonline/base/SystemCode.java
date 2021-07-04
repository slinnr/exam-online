package com.mindskip.examonline.base;

/** 自定义状态码和状态具体内容
 * @author 孙林
 */
public enum SystemCode {
    /**
     * OK
     */
    OK(1, "成功"),
    /**
     * AccessTokenError
     */
    AccessTokenError(400, "用户登录令牌失效"),
    /**
     * UNAUTHORIZED
     */
    UNAUTHORIZED(401, "用户未登录"),
    /**
     * UNAUTHORIZED
     */
    AuthError(402, "用户名或密码错误"),
    /**
     * InnerError
     */
    InnerError(500, "系统内部错误"),
    /**
     * ParameterValidError
     */
    ParameterValidError(501, "参数验证错误"),

    /**
     * AccessDenied
     */
    AccessDenied(502,"用户没有权限访问");

    int code;
    String message;

    SystemCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
