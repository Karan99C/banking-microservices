package preference_service.service;

import org.springframework.stereotype.Service;

import preference_service.dto.PreferenceDTO;

import preference_service.kafa.PreferenceProducer;
import preference_service.model.Preference;
import preference_service.repository.PreferenceRepository;

import java.util.Optional;

@Service
public class PreferenceServiceImpl implements  PreferenceService{

    private final PreferenceRepository repository;
    private final  PreferenceProducer producer;


    public PreferenceServiceImpl(PreferenceRepository repository, PreferenceProducer producer) {
        this.repository = repository;
        this.producer = producer;
    }

    @Override
    public PreferenceDTO getPreferencesById(String userId) {
        Optional<Preference> pref = repository.findById(userId);
        return pref.map(this::convertToDTO).orElse(null);

    }

    @Override
    public PreferenceDTO updatePreferences(PreferenceDTO  dto) {
        // Fetch existing record
        Optional<Preference> existingOpt = repository.findById(dto.getUserId());
        Preference entity = existingOpt.orElse(new Preference());

        // Update fields
        entity.setUserId(dto.getUserId());
        entity.setEmail(dto.isEmail());
        entity.setSms(dto.isSms());
        entity.setPush(dto.isPush());

        // Save to DB
        Preference saved = repository.save(entity);

        // Send to Kafka
        producer.sendUpdatedPreference(convertToDTO(saved));

        return convertToDTO(saved);
    }

    private PreferenceDTO convertToDTO(Preference entity) {
        PreferenceDTO dto = new PreferenceDTO();
        dto.setUserId(entity.getUserId());
        dto.setEmail(entity.isEmail());
        dto.setSms(entity.isSms());
        dto.setPush(entity.isPush());
        return dto;
    }

}
