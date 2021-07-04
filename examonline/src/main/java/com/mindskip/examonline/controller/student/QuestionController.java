package com.mindskip.examonline.controller.student;

import com.mindskip.examonline.base.BaseApiController;
import com.mindskip.examonline.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController("StudentQuestionController")
@RequestMapping(value = "/api/student/question")
@AllArgsConstructor
public class QuestionController extends BaseApiController {

    private final QuestionService questionService;


}
