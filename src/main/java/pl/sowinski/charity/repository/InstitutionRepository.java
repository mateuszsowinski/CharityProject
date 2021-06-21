package pl.sowinski.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sowinski.charity.model.Institution;
public interface InstitutionRepository extends JpaRepository<Institution, Long> {
}
