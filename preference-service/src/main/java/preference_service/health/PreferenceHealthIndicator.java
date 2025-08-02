package preference_service.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import preference_service.repository.PreferenceRepository;

@Component
public class PreferenceHealthIndicator implements HealthIndicator {

    private final PreferenceRepository preferenceRepository;

    public PreferenceHealthIndicator(PreferenceRepository preferenceRepository) {
        this.preferenceRepository = preferenceRepository;
    }

    @Override
    public Health health() {
        try {
            long count = preferenceRepository.count();
            return Health.up().withDetail("Preference DB", "Available").withDetail("Rows", count).build();
        } catch (Exception e) {
            return Health.down().withDetail("Preference DB", "Unavailable").withException(e).build();
        }
    }
}