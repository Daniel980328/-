package com.example.leaderboard;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leaderboard")
public class LeaderboardController {

    private final LeaderboardService leaderboardService;

    public LeaderboardController(LeaderboardService leaderboardService) {
        this.leaderboardService = leaderboardService;
    }

    @GetMapping
    public ResponseEntity<List<LeaderboardRecord>> getLeaderboard() {
        List<LeaderboardRecord> records = leaderboardService.getTop10Records();
        return ResponseEntity.ok(records);
    }

    @PostMapping
    public ResponseEntity<String> addRecord(@RequestBody LeaderboardRecord newRecord) {
        if (newRecord.getInitials() == null || newRecord.getInitials().length() != 3) {
            return ResponseEntity.badRequest().body("Initials must be 3 characters.");
        }
        leaderboardService.saveRecord(newRecord);
        return ResponseEntity.ok("Record added successfully.");
    }
}
