package com.chatbox.chattingApplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "MessageDetails")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long messageId;
    private String lastMessage;

    @OneToOne
    @JoinColumn(name = "userFriendId", nullable = false)
    private UserFriendDetails userFriendDetails;

    private boolean readUnread;
    private LocalDateTime messagecreatedAt;
    private LocalDateTime messageupdatedAt;
    private boolean messageIsDeleted;

    @PrePersist
    protected void messageonCreatefriend() {
        this.messagecreatedAt = LocalDateTime.now();
        this.messageupdatedAt= LocalDateTime.now();
    }

    @PreUpdate
    protected void messageonUpdatefriend() {
        this.messageupdatedAt = LocalDateTime.now();
    }

}
