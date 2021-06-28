package pl.sowinski.charity.institution;

import org.springframework.stereotype.Service;
import pl.sowinski.charity.model.Institution;
import pl.sowinski.charity.repository.InstitutionRepository;

import java.util.List;
import java.util.Optional;
@Service
public class JpaInstitutionService implements InstitutionService {

private final InstitutionRepository institutionRepository;

    public JpaInstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @Override
    public Institution add(Institution addInstitution) {
        return institutionRepository.save(addInstitution);
    }

    @Override
    public Institution getInstitutionById(Long id) {
        Optional<Institution> getInstitutionById = institutionRepository.findById(id);
        return getInstitutionById.get();
    }

    @Override
    public List<Institution> getInstitution() {
        return institutionRepository.findAll();
    }

    @Override
    public void update(Institution updateInstitution) {
        institutionRepository.save(updateInstitution);
    }

    @Override
    public void delete(Long id) {
        institutionRepository.deleteById(id);

    }
}
