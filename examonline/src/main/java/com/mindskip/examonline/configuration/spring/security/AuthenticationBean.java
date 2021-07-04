package com.mindskip.examonline.configuration.spring.security;

import lombok.Data;

/**
 * @author 孙林
 */

@Data
public class AuthenticationBean {
    private String userName;
    private String password;
    private boolean remember;
}
