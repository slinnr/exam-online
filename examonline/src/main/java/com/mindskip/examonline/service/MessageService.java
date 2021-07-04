package com.mindskip.examonline.service;

import com.mindskip.examonline.domain.Message;
import com.mindskip.examonline.domain.MessageUser;
import com.mindskip.examonline.viewmodel.admin.message.MessagePageRequestVM;
import com.mindskip.examonline.viewmodel.student.user.MessageRequestVM;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface MessageService {

    List<Message> selectMessageByIds(List<Integer> ids);

    PageInfo<MessageUser> studentPage(MessageRequestVM requestVM);

    PageInfo<Message> page(MessagePageRequestVM requestVM);

    List<MessageUser> selectByMessageIds(List<Integer> ids);

    void sendMessage(Message message, List<MessageUser> messageUsers);

    void read(Integer id);

    Integer unReadCount(Integer userId);

    Message messageDetail(Integer id);
}