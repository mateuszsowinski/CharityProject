package pl.sowinski.charity.donation;

import org.springframework.stereotype.Service;
import pl.sowinski.charity.model.Donation;

import java.util.List;
import java.util.Optional;
@Service
public interface DonationService {
    Donation add(Donation addDonation);
    Optional<Donation> getDonationById(Long id);
    List<Donation> getDonation();
    void update(Donation updateDonation);
    void delete(Long id);

}
