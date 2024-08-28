package com.chatbox.chattingApplication.service;

import com.chatbox.chattingApplication.dto.UserSignupDTO;
import com.chatbox.chattingApplication.model.Users;

public interface UserService {

    public String signup(UserSignupDTO users);

}
