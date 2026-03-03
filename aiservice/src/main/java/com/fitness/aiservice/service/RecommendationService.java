package com.fitness.aiservice.service;

import com.fitness.aiservice.model.Recommendation;
import com.fitness.aiservice.repository.RecommendationRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationService {
    private final RecommendationRepository recommendationRepository;


    public List<Recommendation> getUserRecommendation(String userId) {
        return recommendationRepository.findByUserId(userId);
    }

    public Recommendation getActivityRecommendation(String activityId) {
        return recommendationRepository.findByActivityId(activityId)
                .orElseThrow(() -> new ResponseStatusException( HttpStatus.NOT_FOUND, "Recommendation not found for activity: " + activityId ));
    }
//    public Recommendation getActivityRecommendation(String activityId) {
//        return recommendationRepository.findByActivityId(activityId)
//                .orElseGet(() -> Recommendation.builder()
//                        .activityId(activityId)
//                        .userId("")   // or leave null
//                        .recommendation("") // empty string instead of throwing
//                        .improvements(Collections.emptyList())
//                        .suggestions(Collections.emptyList())
//                        .safety(Collections.emptyList())
//                        .build()
//                );
//    }


}

