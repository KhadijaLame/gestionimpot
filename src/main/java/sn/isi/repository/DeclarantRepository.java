package sn.isi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.isi.entities.Declarants;

@Repository
public interface DeclarantRep extends JpaRepository<Declarants, Long> {
}
