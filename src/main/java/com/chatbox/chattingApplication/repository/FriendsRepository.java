package com.chatbox.chattingApplication.repository;

import com.chatbox.chattingApplication.model.Friends;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendsRepository extends JpaRepository<Friends,Long> {



}
