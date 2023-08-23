package sn.isi.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.isi.entities.Declaration;
import sn.isi.services.IDeclaration;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class DeclarationController {
    private IDeclaration iDeclaration;
    // build create User REST API
    @PostMapping("/declaration")
    public ResponseEntity<Declaration> createDecla(@RequestBody Declaration declaration){
        Declaration savedDeclaration = iDeclaration.createDeclaration(declaration);
        return new ResponseEntity<>(savedDeclaration, HttpStatus.CREATED);
    }

    // build get user by id REST API
    // http://localhost:8080/api/users/1
    @GetMapping("/declaration/{id}")
    public ResponseEntity<Declaration> getDeclarationById(@PathVariable("id") Long declaId){
        Declaration declaration = iDeclaration.getDeclarationById(declaId);
        return new ResponseEntity<>(declaration, HttpStatus.OK);
    }

    // Build Get All Users REST API
    // http://localhost:8080/api/users
    @GetMapping("/declaration")
    public ResponseEntity<List<Declaration>> getAllDeclaration(){
        List<Declaration> declaration = iDeclaration.getAllDeclaration();
        return new ResponseEntity<>(declaration, HttpStatus.OK);
    }

    // Build Update User REST API
    @PutMapping("/declaration/{id}")
    // http://localhost:8080/api/users/1public
    ResponseEntity<Declaration> updateDeclaration(@PathVariable("id") Long declarationId,
                                          @RequestBody Declaration declaration){
        declaration.setId(declarationId);
        Declaration updateDeclaration = iDeclaration.updateDeclaration(declaration);
        return new ResponseEntity<>(updateDeclaration, HttpStatus.OK);
    }

    // Build Delete User REST API
    @DeleteMapping("/declaration/{id}")
    public ResponseEntity<String> deleteDecl(@PathVariable("id") Long declId){
        iDeclaration.deleteDeclaration(declId);
        return new ResponseEntity<>("Declarationn successfully deleted!", HttpStatus.OK);
    }
}
