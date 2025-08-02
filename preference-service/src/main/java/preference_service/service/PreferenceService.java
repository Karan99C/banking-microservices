package preference_service.service;

import preference_service.dto.PreferenceDTO;
import preference_service.model.Preference;

public interface PreferenceService {
    public PreferenceDTO getPreferencesById(String userId);
    public PreferenceDTO updatePreferences(PreferenceDTO dto);
}
