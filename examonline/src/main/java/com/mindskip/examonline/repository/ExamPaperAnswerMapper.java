package com.mindskip.examonline.repository;

import com.mindskip.examonline.domain.ExamPaperAnswer;
import com.mindskip.examonline.domain.other.KeyValue;
import com.mindskip.examonline.viewmodel.student.exampaper.ExamPaperAnswerPageVM;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface ExamPaperAnswerMapper extends BaseMapper<ExamPaperAnswer> {
    int deleteByPrimaryKey(Integer id);

    int insert(ExamPaperAnswer record);

    int insertSelective(ExamPaperAnswer record);

    ExamPaperAnswer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExamPaperAnswer record);

    int updateByPrimaryKey(ExamPaperAnswer record);

    List<ExamPaperAnswer> studentPage(ExamPaperAnswerPageVM requestVM);

    Integer selectAllCount();

    List<KeyValue> selectCountByDate(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

    ExamPaperAnswer getByPidUid(@Param("pid") Integer paperId, @Param("uid") Integer uid);

}
