package preference_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import preference_service.dto.PreferenceDTO;
import preference_service.service.PreferenceService;

@RestController
@RequestMapping("/preferences")
public class PreferenceController {

    @Autowired
    private PreferenceService service;

    @GetMapping("/{userId}")
    public PreferenceDTO getUserPreference(@PathVariable String userId) {
        return service.getPreferencesById(userId);
    }

    @PutMapping("/save")
    public PreferenceDTO updateUserPreference(@RequestBody PreferenceDTO dto) {
        return service.updatePreferences(dto);
    }
}
