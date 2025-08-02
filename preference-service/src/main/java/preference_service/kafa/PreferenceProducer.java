package preference_service.kafa;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import preference_service.dto.PreferenceDTO;

@Component
public class PreferenceProducer {

    private final KafkaTemplate<String, PreferenceDTO> kafkaTemplate;

    @Value("${kafka.topic.preference}")
    private String topic;

    public PreferenceProducer(KafkaTemplate<String, PreferenceDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendUpdatedPreference(PreferenceDTO dto) {
        kafkaTemplate.send(topic, dto.getUserId(), dto);
    }
}
