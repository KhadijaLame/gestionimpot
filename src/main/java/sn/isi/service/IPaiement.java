package sn.isi.services;

import sn.isi.entities.Declarants;
import sn.isi.entities.Paiement;

import java.util.List;

public interface IPaiement {
    Paiement CreatePaiement (Paiement paiement);
    Paiement getPaiementById(Long paiementId);

    List<Paiement> getAllPaiement();

    Paiement updatePaiement(Paiement paiement);

    void deletePaiement(Long paiementId);
}
