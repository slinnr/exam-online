package com.mindskip.examonline.viewmodel.admin.message;

import com.mindskip.examonline.base.BasePage;
import lombok.Data;

@Data
public class MessagePageRequestVM extends BasePage {
    private String sendUserName;
}
