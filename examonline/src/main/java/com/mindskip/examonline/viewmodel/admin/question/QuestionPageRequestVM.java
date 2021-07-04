package com.mindskip.examonline.viewmodel.admin.question;

import com.mindskip.examonline.base.BasePage;
import lombok.Data;

@Data
public class QuestionPageRequestVM extends BasePage {

    private Integer id;
    private Integer level;
    private Integer subjectId;
    private Integer questionType;
}
