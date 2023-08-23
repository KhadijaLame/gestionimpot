package sn.isi.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.isi.entities.Declarants;
import sn.isi.entities.Paiement;
import sn.isi.services.IPaiement;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class PaiementController {
    private IPaiement iPaiement;



}
