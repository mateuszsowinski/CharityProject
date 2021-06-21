package pl.sowinski.charity.institution;

import org.springframework.stereotype.Service;
import pl.sowinski.charity.model.Institution;

import java.util.List;
import java.util.Optional;
@Service
public interface InstitutionService {
    Institution add(Institution addInstitution);
    Optional<Institution> getInstitutionById(Long id);
    List<Institution> getInstitution();
    void update(Institution updateInstitution);
    void delete(Long id);
}
