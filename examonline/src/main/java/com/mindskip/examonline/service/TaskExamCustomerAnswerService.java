package com.mindskip.examonline.service;

import com.mindskip.examonline.domain.ExamPaper;
import com.mindskip.examonline.domain.ExamPaperAnswer;
import com.mindskip.examonline.domain.TaskExamCustomerAnswer;

import java.util.Date;
import java.util.List;

public interface TaskExamCustomerAnswerService extends BaseService<TaskExamCustomerAnswer> {

    void insertOrUpdate(ExamPaper examPaper, ExamPaperAnswer examPaperAnswer, Date now);

    TaskExamCustomerAnswer selectByTUid(Integer tid, Integer uid);

    List<TaskExamCustomerAnswer> selectByTUid(List<Integer> taskIds, Integer uid);
}
