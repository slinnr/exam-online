package com.mindskip.examonline.repository;

import com.mindskip.examonline.domain.UserEventLog;
import com.mindskip.examonline.domain.other.KeyValue;
import com.mindskip.examonline.viewmodel.admin.user.UserEventPageRequestVM;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface UserEventLogMapper extends BaseMapper<UserEventLog> {

    int deleteByPrimaryKey(Integer id);

    int insert(UserEventLog record);

    int insertSelective(UserEventLog record);

    UserEventLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserEventLog record);

    int updateByPrimaryKey(UserEventLog record);

    List<UserEventLog> getUserEventLogByUserId(Integer id);

    List<UserEventLog> page(UserEventPageRequestVM requestVM);

    List<KeyValue> selectCountByDate(@Param("startTime") Date startTime, @Param("endTime") Date endTime);
}
