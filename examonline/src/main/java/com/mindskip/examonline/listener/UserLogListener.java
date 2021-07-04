package com.mindskip.examonline.listener;

import com.mindskip.examonline.event.UserEvent;
import com.mindskip.examonline.service.UserEventLogService;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserLogListener implements ApplicationListener<UserEvent> {

    private UserEventLogService userEventLogService;

    @Override
    public void onApplicationEvent(UserEvent userEvent) {
        userEventLogService.insertByFilter(userEvent.getUserEventLog());
    }

}
