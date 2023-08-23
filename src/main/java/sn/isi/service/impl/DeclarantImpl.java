package sn.isi.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sn.isi.entities.Declarants;
import sn.isi.repository.DeclarantRepository;
import sn.isi.services.IDeclarant;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DeclarantImpl implements IDeclarant {

    private DeclarantRepository declarantRepository;

    @Override
    public Declarants createDeclarants(Declarants declarants) {
        return declarantRepository.save(declarants);
    }

    @Override
    public Declarants getDeclarantsById(Long declarantsId) {
        Optional<Declarants> optionalDeclarants =declarantRepository.findById(declarantsId);
        return optionalDeclarants.get();
    }

    @Override
    public List<Declarants> getAllDeclarants() {
        return declarantRepository.findAll();
    }

    @Override
    public Declarants updateDeclarants(Declarants declarants) {
        Declarants existingDeclarants = declarantRepository.findById(declarants.getId()).get();
        existingDeclarants.setRaisonsociable(declarants.getRaisonsociable());
        existingDeclarants.setAdresse(declarants.getAdresse());
        existingDeclarants.setEmail(declarants.getEmail());
        existingDeclarants.setTelephone(declarants.getTelephone());
        Declarants updatedDeclarants = declarantRepository.save(existingDeclarants);
        return updatedDeclarants;
    }

    @Override
    public void deleteDeclarants(Long declarantsId) {
        declarantRepository.deleteById(declarantsId);

    }
}
