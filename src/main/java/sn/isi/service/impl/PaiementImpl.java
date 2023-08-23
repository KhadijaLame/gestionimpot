package sn.isi.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sn.isi.entities.Paiement;
import sn.isi.repository.PaiementRep;
import sn.isi.services.IPaiement;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PaiementImpl implements IPaiement {
    private PaiementRepository paiementRepository;

    @Override
    public Paiement CreatePaiement(Paiement paiement) {return  paiementRepository.save(paiement);

    }

    @Override
    public Paiement getPaiementById(Long paiementId) {
        Optional<Paiement> optionalPaiement =paiementRepository.findById(paiementId);
        return optionalPaiement.get();
    }

    @Override
    public List<Paiement> getAllPaiement() {
        return paiementRepository.findAll();
    }

    @Override
    public Paiement updatePaiement(Paiement paiement) {
        Paiement existingPaiement = paiementRepository.findById(paiement.getId()).get();
        existingPaiement.setDatePaiement(paiement.getDatePaiement());
        existingPaiement.setMontantPaiement(paiement.getMontantPaiement());
        existingPaiement.setDeclaration(paiement.getDeclaration());
        Paiement updatedPaiement = paiementRepository.save(existingPaiement);
        return updatedPaiement;
    }

    @Override
    public void deletePaiement(Long paiementId) {
        paiementRepository.deleteById(paiementId);

    }
}
