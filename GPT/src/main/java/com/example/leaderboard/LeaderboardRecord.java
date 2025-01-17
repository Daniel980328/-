package com.example.leaderboard;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class LeaderboardRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 3)
    private String initials;

    @Column(nullable = false)
    private int time;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
