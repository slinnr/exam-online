package com.mindskip.examonline.configuration.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;


/**
 * @Description
 * @Date 2021/1/9 下午6:19
 */
@ConfigurationProperties(prefix = "system")
@Data
public class SystemConfig {
    private PasswordKeyConfig pwdKey;
    private List<String> securityIgnoreUrls;
    private QnConfig qn;
}
