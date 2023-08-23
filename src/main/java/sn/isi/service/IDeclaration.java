package sn.isi.services;

import sn.isi.entities.Declarants;
import sn.isi.entities.Declaration;

import java.util.List;

public interface IDeclaration {
    Declaration createDeclaration(Declaration declaration);

    Declaration getDeclarationById(Long DeclarationId);

    List<Declaration> getAllDeclaration();

    Declaration updateDeclaration(Declaration declaration);

    void deleteDeclaration(Long DeclarationId);
}
