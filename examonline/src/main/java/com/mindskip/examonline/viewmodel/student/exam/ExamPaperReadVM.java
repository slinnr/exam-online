package com.mindskip.examonline.viewmodel.student.exam;

import com.mindskip.examonline.viewmodel.admin.exam.ExamPaperEditRequestVM;
import lombok.Data;

@Data
public class ExamPaperReadVM {
    private ExamPaperEditRequestVM paper;
    private ExamPaperSubmitVM answer;
}
