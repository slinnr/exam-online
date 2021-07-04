package com.mindskip.examonline.repository;

import com.mindskip.examonline.domain.Subject;
import com.mindskip.examonline.viewmodel.admin.education.SubjectPageRequestVM;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SubjectMapper  extends BaseMapper<Subject> {
    int deleteByPrimaryKey(Integer id);

    int insert(Subject record);

    int insertSelective(Subject record);

    Subject selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Subject record);

    int updateByPrimaryKey(Subject record);

    List<Subject> getSubjectByLevel(Integer level);

    List<Subject> allSubject();

    List<Subject> page(SubjectPageRequestVM requestVM);
}
