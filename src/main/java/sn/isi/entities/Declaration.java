package sn.isi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "declaration")
public class Declaration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "dateDeclaration")
    private LocalDate dateDeclaration;
    @Column(name = "montantDeclaration")
    private double montantDeclaration;
    @ManyToOne
    @JoinColumn(name = "id_declarants")
    private Declarants declarants;

    @OneToMany(mappedBy = "declaration", cascade = CascadeType.ALL)
    private List<Paiement> paiement;


}
