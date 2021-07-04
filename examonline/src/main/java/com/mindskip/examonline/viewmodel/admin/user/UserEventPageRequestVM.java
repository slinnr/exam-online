package com.mindskip.examonline.viewmodel.admin.user;

import com.mindskip.examonline.base.BasePage;
import lombok.Data;



@Data
public class UserEventPageRequestVM extends BasePage {

    private Integer userId;

    private String userName;

}
