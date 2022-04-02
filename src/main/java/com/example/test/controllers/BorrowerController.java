package com.example.test.controllers;

import com.example.test.bases.BaseController;
import com.example.test.dtos.BorrowerDTO;
import com.example.test.models.Borrower;
import com.example.test.services.IBorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/borrower")
public class BorrowerController extends BaseController<Borrower> {
    @Autowired
    private IBorrowerService borrowerService;

    @PostMapping("/{idTraffic}")
    public ResponseEntity<?> createBorrower(@RequestBody @Valid BorrowerDTO borrowerDTO, @PathVariable( name = "idTraffic") Integer idTraffic){
        return this.resSuccess(borrowerService.createBorrower(borrowerDTO, idTraffic));
    }

    @GetMapping("/get-all-by-IdTraffic/{idTraffic}")
    public ResponseEntity<?> getAllByIdTraffic(@PathVariable(name="idTraffic") Integer idTraffic){
        return this.resSetSuccess(borrowerService.getAllByIdTraffic(idTraffic));
    }

    @PatchMapping("/edit-by-id/{idBorrower}")
    public ResponseEntity<?> editById(@RequestBody BorrowerDTO borrowerDTO,@PathVariable(name="idBorrower") Integer idBorrower ){
        return  this.resSuccess(borrowerService.editById(borrowerDTO,idBorrower));
    }

    @DeleteMapping("/delete/{idBorrower}")
    public ResponseEntity<?> deleteById(@PathVariable(name ="idBorrower") Integer idBorrower ){
        return this.resSuccess(borrowerService.deleteById(idBorrower));
    }

}
