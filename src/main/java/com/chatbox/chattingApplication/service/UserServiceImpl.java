package com.chatbox.chattingApplication.service;

import com.chatbox.chattingApplication.dto.UserSignupDTO;
import com.chatbox.chattingApplication.model.Users;
import com.chatbox.chattingApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private ValidationService validationService;
    @Autowired
    private UserRepository userRepository;


            public String signup(UserSignupDTO userSignupDTO) {
                // Validate the email format
                if (!validationService.isValid(userSignupDTO.getUserEmail())) {
                    return "Invalid email format";
                }

                // Check if the email already exists
                if (userRepository.findByUserEmail(userSignupDTO.getUserEmail()).isPresent()) {
                    return "Email already exists";
                }

                // Check if password and confirmPassword match
                if (!userSignupDTO.getPassword().equals(userSignupDTO.getConfirmPassword())) {
                    return "Passwords do not match";
                }
                Users users = new Users();
                // Create a new Users entity and set the values from the DTO
                users.setUserId(userSignupDTO.getUserId());
                users.setUserName(userSignupDTO.getUserName());
                users.setUserEmail(userSignupDTO.getUserEmail());
                users.setPassword(userSignupDTO.getPassword());

                users.setCreatedAt(userSignupDTO.getCreatedAt()); // Assuming createdAt is set or handled elsewhere
                users.setUpdatedAt(userSignupDTO.getUpdatedAt()); // Assuming updatedAt is set or handled elsewhere
                users.setDeleted(userSignupDTO.isDeleted());

                // Save the user to the database
                userRepository.save(users);
                return "User Inserted";
            }

}
