package com.mindskip.examonline.context;

import com.mindskip.examonline.domain.User;
import com.mindskip.examonline.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

/**
 * @Description  获取和设置user
 * @Date 2021/1/9 下午5:42
 */
@Component
@AllArgsConstructor
public class WebContext {
    private static final String USER_ATTRIBUTES = "USER_ATTRIBUTES";
    private final UserService userService;


    public void setCurrentUser(User user) {
        RequestContextHolder.currentRequestAttributes().setAttribute(USER_ATTRIBUTES, user, RequestAttributes.SCOPE_REQUEST);
    }

    public User getCurrentUser() {
        User user = (User) RequestContextHolder.currentRequestAttributes().getAttribute(USER_ATTRIBUTES, RequestAttributes.SCOPE_REQUEST);
        if (null != user) {
            return user;
        } else {
            org.springframework.security.core.userdetails.User springUser = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (null == springUser) {
                return null;
            }
            user = userService.getUserByUserName(springUser.getUsername());
            if (null != user) {
                setCurrentUser(user);
            }
            return user;
        }
    }
}
