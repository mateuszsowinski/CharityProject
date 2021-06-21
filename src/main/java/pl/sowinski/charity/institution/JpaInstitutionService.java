package pl.sowinski.charity.institution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sowinski.charity.model.Institution;
import pl.sowinski.repository.InstitutionRepository;

import java.util.List;
import java.util.Optional;
@Service
public class JpaInstitutionService implements InstitutionService {

   public final InstitutionRepository institutionRepository;

    public JpaInstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @Override
    public Institution add(Institution addInstitution) {
        return institutionRepository.save(addInstitution);
    }

    @Override
    public Optional<Institution> getInstitutionById(Long id) {
        return institutionRepository.findById(id);
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
