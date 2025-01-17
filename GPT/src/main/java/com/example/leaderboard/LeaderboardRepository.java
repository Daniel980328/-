package com.example.leaderboard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaderboardRepository extends JpaRepository<LeaderboardRecord, Long> {
    List<LeaderboardRecord> findTop10ByOrderByTimeDesc();
}
