package com.mindskip.examonline.viewmodel.admin.education;

import com.mindskip.examonline.viewmodel.BaseVM;
import lombok.Data;

@Data
public class SubjectResponseVM extends BaseVM {
    private Integer id;

    private String name;

    private Integer level;

    private String levelName;
}
