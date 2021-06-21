package pl.sowinski.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sowinski.charity.model.Donation;
@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {
}
