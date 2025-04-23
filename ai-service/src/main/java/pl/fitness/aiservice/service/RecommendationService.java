package pl.fitness.aiservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.fitness.aiservice.model.Recommendation;
import pl.fitness.aiservice.repo.RecommendationRepository;

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
                .orElseThrow(() -> new RuntimeException("No recommendation Found for this activity: " + activityId));
    }
}
