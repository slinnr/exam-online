package com.mindskip.examonline.service;

import com.mindskip.examonline.domain.ExamPaper;
import com.mindskip.examonline.domain.User;
import com.mindskip.examonline.viewmodel.admin.exam.ExamPaperEditRequestVM;
import com.mindskip.examonline.viewmodel.admin.exam.ExamPaperPageRequestVM;
import com.mindskip.examonline.viewmodel.student.dashboard.PaperFilter;
import com.mindskip.examonline.viewmodel.student.dashboard.PaperInfo;
import com.mindskip.examonline.viewmodel.student.exam.ExamPaperPageVM;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ExamPaperService extends BaseService<ExamPaper> {

    PageInfo<ExamPaper> page(ExamPaperPageRequestVM requestVM);

    PageInfo<ExamPaper> taskExamPage(ExamPaperPageRequestVM requestVM);

    PageInfo<ExamPaper> studentPage(ExamPaperPageVM requestVM);

    ExamPaper savePaperFromVM(ExamPaperEditRequestVM examPaperEditRequestVM, User user);

    ExamPaperEditRequestVM examPaperToVM(Integer id);

    List<PaperInfo> indexPaper(PaperFilter paperFilter);

    Integer selectAllCount();

    List<Integer> selectMothCount();
}
