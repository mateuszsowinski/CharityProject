package pl.sowinski.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.sowinski.charity.model.Donation;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query(value = "SELECT SUM(quantity) FROM Donation ", nativeQuery = true)
    Integer sumQuantity();
    @Query(value = "SELECT COUNT(id) FROM Donation", nativeQuery = true)
    Integer countDonationById();

}