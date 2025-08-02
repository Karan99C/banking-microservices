package com.reward.controller;

import com.reward.model.RewardRecord;
import com.reward.service.RewardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rewards")
@Tag(name = "Reward History", description = "Query reward history")
public class RewardController {
    private final RewardService rewardService;

    public RewardController(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    @Operation(summary = "Get rewards by customer ID")
    @GetMapping("/{customerId}")
    public ResponseEntity<List<RewardRecord>> getRewards(@PathVariable String customerId) {
        List<RewardRecord> records=rewardService.getRewardsForCustomer(customerId);
        return ResponseEntity.ok(records);
    }

    @Operation(summary = "save rewards record")
    @ApiResponse(responseCode = "200", description = "Reward saved successfully")
    @PostMapping("/save")
    public  ResponseEntity<String> saveReward(@RequestBody RewardRecord rewardRecord){
        return ResponseEntity.ok("Reward saved Successfully");
    }
}
