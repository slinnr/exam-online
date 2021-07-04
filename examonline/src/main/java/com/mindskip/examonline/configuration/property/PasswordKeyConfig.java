package com.mindskip.examonline.configuration.property;

import lombok.Data;
/**
 * @Description rsa加密的公钥和私钥
 * @Date 2021/1/10 下午5:25
 */
@Data
public class PasswordKeyConfig {
    private String publicKey;
    private String privateKey;
}
