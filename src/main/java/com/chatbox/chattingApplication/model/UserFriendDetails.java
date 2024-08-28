package com.chatbox.chattingApplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "UserFriendDetails")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserFriendDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userFriendId;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private Users users;

    @ManyToOne
    @JoinColumn(name = "friendId", nullable = false)
    private Friends friend;

    private LocalDateTime userFriendcreatedAt;
    private LocalDateTime userFriendupdatedAt;
    private boolean userFriendisDeleted;

    @PrePersist
    protected void userFriendonCreatefriend() {
        this.userFriendcreatedAt = LocalDateTime.now();
        this.userFriendupdatedAt= LocalDateTime.now();
    }

    @PreUpdate
    protected void userFriendonUpdatefriend() {
        this.userFriendupdatedAt = LocalDateTime.now();
    }

    @OneToOne(mappedBy = "userFriendDetails", cascade = CascadeType.ALL)
    private MessageDetails messageDetails;



}
