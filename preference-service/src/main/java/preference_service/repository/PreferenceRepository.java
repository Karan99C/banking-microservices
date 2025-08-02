package preference_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import preference_service.model.Preference;

@Repository
public interface PreferenceRepository extends JpaRepository<Preference,String> {
}
