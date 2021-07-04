package com.mindskip.examonline.viewmodel.student.question.answer;

import com.mindskip.examonline.viewmodel.admin.question.QuestionEditRequestVM;
import com.mindskip.examonline.viewmodel.student.exam.ExamPaperSubmitItemVM;
import lombok.Data;

@Data
public class QuestionAnswerVM {
    private QuestionEditRequestVM questionVM;
    private ExamPaperSubmitItemVM questionAnswerVM;
}
