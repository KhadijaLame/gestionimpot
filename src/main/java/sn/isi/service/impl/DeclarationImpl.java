package sn.isi.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sn.isi.entities.Declarants;
import sn.isi.entities.Declaration;
import sn.isi.repository.DeclarationRep;
import sn.isi.services.IDeclaration;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DeclarationImpl implements IDeclaration {
    private DeclarationRepository declarationRepository;

    @Override
    public Declaration createDeclaration(Declaration declaration) {
        return declarationRepository.save(declaration);
    }

    @Override
    public Declaration getDeclarationById(Long declarationId) {
        Optional<Declaration> optionalDeclaration =declarationRepository.findById(declarationId);
        return optionalDeclaration.get();    }

    @Override
    public List<Declaration> getAllDeclaration() {
        return declarationRepository.findAll();
    }

    @Override
    public Declaration updateDeclaration(Declaration declaration) {
        Declaration existingDeclaration = declarationRepository.findById(declaration.getId()).get();
        existingDeclaration.setDateDeclaration(declaration.getDateDeclaration());
        existingDeclaration.setMontantDeclaration(declaration.getMontantDeclaration());
        existingDeclaration.setPaiement(declaration.getPaiement());
        Declaration updatedDeclaration = .save(existingDeclaration);
        return updatedDeclaration;
    }

    @Override
    public void deleteDeclaration(Long declarationId) {
        declarationRepository.deleteById(declarationId);
    }
}