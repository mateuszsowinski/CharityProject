package pl.sowinski.charity.institution;

import org.springframework.stereotype.Service;
import pl.sowinski.charity.model.Institution;

import java.util.List;

@Service
public interface InstitutionService {
    Institution add(Institution addInstitution);
    Institution getInstitutionById(Long id);
    List<Institution> getInstitution();
    void update(Institution updateInstitution);
    void delete(Long id);
}
