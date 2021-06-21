package pl.sowinski.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sowinski.charity.model.Institution;
public interface InstitutionRepository extends JpaRepository<Institution, Long> {
}
