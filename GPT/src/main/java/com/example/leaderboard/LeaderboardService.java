package com.example.leaderboard;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaderboardService {

    private final LeaderboardRepository leaderboardRepository;

    public LeaderboardService(LeaderboardRepository leaderboardRepository) {
        this.leaderboardRepository = leaderboardRepository;
    }

    public List<LeaderboardRecord> getTop10Records() {
        return leaderboardRepository.findTop10ByOrderByTimeDesc();
    }

    public void saveRecord(LeaderboardRecord record) {
        leaderboardRepository.save(record);
    }
}
