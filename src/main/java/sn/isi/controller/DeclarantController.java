package sn.isi.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.isi.entities.Declarants;
import sn.isi.services.IDeclarant;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class DeclController {

    private IDeclarant iDeclarant;

    // build create User REST API
    @PostMapping("/declarants")
    public ResponseEntity<Declarants> createDecl(@RequestBody Declarants declarants){
        Declarants savedDeclarants = iDeclarant.createDeclarants(declarants);
        return new ResponseEntity<>(savedDeclarants, HttpStatus.CREATED);
    }

    // build get user by id REST API
    // http://localhost:8080/api/users/1
    @GetMapping("/declarants/{id}")
    public ResponseEntity<Declarants> getDeclarantsById(@PathVariable("id") Long declId){
        Declarants declarants = iDeclarant.getDeclarantsById(declId);
        return new ResponseEntity<>(declarants, HttpStatus.OK);
    }

    // Build Get All Users REST API
    // http://localhost:8080/api/users
    @GetMapping("/declarants")
    public ResponseEntity<List<Declarants>> getAllDeclarants(){
        List<Declarants> declarants = iDeclarant.getAllDeclarants();
        return new ResponseEntity<>(declarants, HttpStatus.OK);
    }

    // Build Update User REST API
    @PutMapping("/declarants/{id}")
    // http://localhost:8080/api/users/1
    public ResponseEntity<Declarants> updateDeclarants(@PathVariable("id") Long declId,
                                           @RequestBody Declarants declarants){
        declarants.setId(declId);
        Declarants updatedDecl = iDeclarant.updateDeclarants(declarants);
        return new ResponseEntity<>(updatedDecl, HttpStatus.OK);
    }

    // Build Delete User REST API
    @DeleteMapping("/declarants/{id}")
    public ResponseEntity<String> deleteDecl(@PathVariable("id") Long declId){
        iDeclarant.deleteDeclarants(declId);
        return new ResponseEntity<>("Declarant supprimé!", HttpStatus.OK);
    }
}
