package pl.sowinski.charity.donation;

import org.springframework.stereotype.Service;
import pl.sowinski.charity.model.Donation;
import pl.sowinski.charity.repository.DonationRepository;

import java.util.List;
import java.util.Optional;
@Service
public class JpaDonationService implements DonationService {

    public final DonationRepository donationRepository;

    public JpaDonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    @Override
    public Donation add(Donation addDonation) {
        return donationRepository.save(addDonation);
    }

    @Override
    public Donation getDonationById(Long id) {
        Optional<Donation> getDonationById = donationRepository.findById(id);
        return getDonationById.get();
    }

    @Override
    public List<Donation> getDonation() {
        return donationRepository.findAll();
    }

    @Override
    public void update(Donation updateDonation) {
        donationRepository.save(updateDonation);
    }

    @Override
    public void delete(Long id) {
        donationRepository.deleteById(id);
    }
}
