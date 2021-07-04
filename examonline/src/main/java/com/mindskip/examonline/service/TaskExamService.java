package com.mindskip.examonline.service;

import com.mindskip.examonline.domain.TaskExam;
import com.mindskip.examonline.domain.User;
import com.mindskip.examonline.viewmodel.admin.task.TaskPageRequestVM;
import com.mindskip.examonline.viewmodel.admin.task.TaskRequestVM;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface TaskExamService extends BaseService<TaskExam> {

    PageInfo<TaskExam> page(TaskPageRequestVM requestVM);

    void edit(TaskRequestVM model, User user);

    TaskRequestVM taskExamToVM(Integer id);

    List<TaskExam> getByGradeLevel(Integer gradeLevel);
}
