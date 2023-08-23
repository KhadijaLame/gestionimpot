package sn.isi.services;

import sn.isi.entities.Declarants;

import java.util.List;

public interface IDeclarant {
    Declarants createDeclarants(Declarants declarants);

    Declarants getDeclarantsById(Long declarantsId);

    List<Declarants> getAllDeclarants();

    Declarants updateDeclarants(Declarants declarants);

    void deleteDeclarants(Long declarantsId);

}
