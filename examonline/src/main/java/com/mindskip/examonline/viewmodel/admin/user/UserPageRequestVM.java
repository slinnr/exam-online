package com.mindskip.examonline.viewmodel.admin.user;

import com.mindskip.examonline.base.BasePage;
import lombok.Data;


@Data
public class UserPageRequestVM extends BasePage {

    private String userName;
    private Integer role;

}
