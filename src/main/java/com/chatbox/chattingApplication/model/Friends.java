package com.chatbox.chattingApplication.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "Friends")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Friends {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long friendId;
    private String friendName;
    private String friendEmail;
    private LocalDateTime friendCreatedAt;
    private LocalDateTime friendUpdatedAt;
    private boolean friendisDeleted;

    @PrePersist
    protected void onCreatefriend() {
        this.friendCreatedAt = LocalDateTime.now();
        this.friendUpdatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdatefriend() {
        this.friendUpdatedAt = LocalDateTime.now();
    }

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    @JsonIgnore
    private Users users;





}
