package com.mindskip.examonline.controller.admin;

import com.mindskip.examonline.base.BaseApiController;
import com.mindskip.examonline.base.RestResponse;
import com.mindskip.examonline.domain.ExamPaper;
import com.mindskip.examonline.service.ExamPaperService;
import com.mindskip.examonline.utility.DateTimeUtil;
import com.mindskip.examonline.utility.PageInfoHelper;
import com.mindskip.examonline.viewmodel.admin.exam.ExamPaperPageRequestVM;
import com.mindskip.examonline.viewmodel.admin.exam.ExamPaperEditRequestVM;
import com.mindskip.examonline.viewmodel.admin.exam.ExamResponseVM;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController("AdminExamPaperController")
@RequestMapping(value = "/api/admin/exam/paper")
public class ExamPaperController extends BaseApiController {

    private final ExamPaperService examPaperService;

    public ExamPaperController(ExamPaperService examPaperService) {
        this.examPaperService = examPaperService;
    }

    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public RestResponse<PageInfo<ExamResponseVM>> pageList(@RequestBody ExamPaperPageRequestVM model) {
        PageInfo<ExamPaper> pageInfo = examPaperService.page(model);
        PageInfo<ExamResponseVM> page = PageInfoHelper.copyMap(pageInfo, e -> {
            ExamResponseVM vm = modelMapper.map(e, ExamResponseVM.class);
            vm.setCreateTime(DateTimeUtil.dateFormat(e.getCreateTime()));
            return vm;
        });
        return RestResponse.ok(page);
    }



    @RequestMapping(value = "/taskExamPage", method = RequestMethod.POST)
    public RestResponse<PageInfo<ExamResponseVM>> taskExamPageList(@RequestBody ExamPaperPageRequestVM model) {
        PageInfo<ExamPaper> pageInfo = examPaperService.taskExamPage(model);
        PageInfo<ExamResponseVM> page = PageInfoHelper.copyMap(pageInfo, e -> {
            ExamResponseVM vm = modelMapper.map(e, ExamResponseVM.class);
            vm.setCreateTime(DateTimeUtil.dateFormat(e.getCreateTime()));
            return vm;
        });
        return RestResponse.ok(page);
    }



    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public RestResponse<ExamPaperEditRequestVM> edit(@RequestBody @Valid ExamPaperEditRequestVM model) {
        ExamPaper examPaper = examPaperService.savePaperFromVM(model, getCurrentUser());
        ExamPaperEditRequestVM newVM = examPaperService.examPaperToVM(examPaper.getId());
        return RestResponse.ok(newVM);
    }

    @RequestMapping(value = "/select/{id}", method = RequestMethod.POST)
    public RestResponse<ExamPaperEditRequestVM> select(@PathVariable Integer id) {
        ExamPaperEditRequestVM vm = examPaperService.examPaperToVM(id);
        return RestResponse.ok(vm);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public RestResponse delete(@PathVariable Integer id) {
        ExamPaper examPaper = examPaperService.selectById(id);
        examPaper.setDeleted(true);
        examPaperService.updateByIdFilter(examPaper);
        return RestResponse.ok();
    }
}
