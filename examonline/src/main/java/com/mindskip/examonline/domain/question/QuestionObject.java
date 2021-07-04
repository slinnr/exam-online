package com.mindskip.examonline.domain.question;


import lombok.Data;

import java.util.List;

@Data
public class QuestionObject {

    private String titleContent;

    private String analyze;

    private List<QuestionItemObject> questionItemObjects;//题中的选项

    private String correct;
}
