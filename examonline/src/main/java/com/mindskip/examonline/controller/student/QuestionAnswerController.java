package com.mindskip.examonline.controller.student;

import com.mindskip.examonline.base.BaseApiController;
import com.mindskip.examonline.base.RestResponse;
import com.mindskip.examonline.domain.ExamPaperQuestionCustomerAnswer;
import com.mindskip.examonline.domain.Subject;
import com.mindskip.examonline.domain.TextContent;
import com.mindskip.examonline.domain.question.QuestionObject;
import com.mindskip.examonline.service.ExamPaperQuestionCustomerAnswerService;
import com.mindskip.examonline.service.QuestionService;
import com.mindskip.examonline.service.SubjectService;
import com.mindskip.examonline.service.TextContentService;
import com.mindskip.examonline.utility.DateTimeUtil;
import com.mindskip.examonline.utility.HtmlUtil;
import com.mindskip.examonline.utility.JsonUtil;
import com.mindskip.examonline.utility.PageInfoHelper;
import com.mindskip.examonline.viewmodel.admin.question.QuestionEditRequestVM;
import com.mindskip.examonline.viewmodel.student.exam.ExamPaperSubmitItemVM;
import com.mindskip.examonline.viewmodel.student.question.answer.QuestionAnswerVM;
import com.mindskip.examonline.viewmodel.student.question.answer.QuestionPageStudentRequestVM;
import com.mindskip.examonline.viewmodel.student.question.answer.QuestionPageStudentResponseVM;
import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController("StudentQuestionAnswerController")
@RequestMapping(value = "/api/student/question/answer")
@AllArgsConstructor
public class QuestionAnswerController extends BaseApiController {

    private final ExamPaperQuestionCustomerAnswerService examPaperQuestionCustomerAnswerService;
    private final QuestionService questionService;
    private final TextContentService textContentService;
    private final SubjectService subjectService;

    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public RestResponse<PageInfo<QuestionPageStudentResponseVM>> pageList(@RequestBody QuestionPageStudentRequestVM model) {
        model.setCreateUser(getCurrentUser().getId());
        PageInfo<ExamPaperQuestionCustomerAnswer> pageInfo = examPaperQuestionCustomerAnswerService.studentPage(model);
        PageInfo<QuestionPageStudentResponseVM> page = PageInfoHelper.copyMap(pageInfo, q -> {
            Subject subject = subjectService.selectById(q.getSubjectId());
            QuestionPageStudentResponseVM vm = modelMapper.map(q, QuestionPageStudentResponseVM.class);
            vm.setCreateTime(DateTimeUtil.dateFormat(q.getCreateTime()));
            TextContent textContent = textContentService.selectById(q.getQuestionTextContentId());
            QuestionObject questionObject = JsonUtil.toJsonObject(textContent.getContent(), QuestionObject.class);
            String clearHtml = HtmlUtil.clear(questionObject.getTitleContent());
            vm.setShortTitle(clearHtml);
            vm.setSubjectName(subject.getName());
            return vm;
        });
        return RestResponse.ok(page);
    }


    @RequestMapping(value = "/select/{id}", method = RequestMethod.POST)
    public RestResponse<QuestionAnswerVM> select(@PathVariable Integer id) {
        QuestionAnswerVM vm = new QuestionAnswerVM();
        ExamPaperQuestionCustomerAnswer examPaperQuestionCustomerAnswer = examPaperQuestionCustomerAnswerService.selectById(id);
        ExamPaperSubmitItemVM questionAnswerVM = examPaperQuestionCustomerAnswerService.examPaperQuestionCustomerAnswerToVM(examPaperQuestionCustomerAnswer);
        QuestionEditRequestVM questionVM = questionService.getQuestionEditRequestVM(examPaperQuestionCustomerAnswer.getQuestionId());
        vm.setQuestionVM(questionVM);
        vm.setQuestionAnswerVM(questionAnswerVM);
        return RestResponse.ok(vm);
    }

}
