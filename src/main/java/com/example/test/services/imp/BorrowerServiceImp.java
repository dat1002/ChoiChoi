package com.example.test.services.imp;

import com.example.test.dtos.BorrowerDTO;
import com.example.test.exceptions.BadRequestException;
import com.example.test.exceptions.NotFoundException;
import com.example.test.models.Borrower;
import com.example.test.models.Traffic;
import com.example.test.repositories.BorrowerRepository;
import com.example.test.repositories.TrafficRepository;
import com.example.test.services.IBorrowerService;
import com.example.test.utils.ConvertDTOToDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class BorrowerServiceImp implements IBorrowerService {

    @Autowired
    private BorrowerRepository borrowerRepository;

    @Autowired
    private TrafficRepository trafficRepository;


    @Override
    public Borrower createBorrower(BorrowerDTO borrowerDTO, Integer idTraffic) {
        Borrower oldBorrower = borrowerRepository.findByCodeAndTraffic(borrowerDTO.getCode(), idTraffic);
        if(oldBorrower != null){
            throw new BadRequestException("Đã tồn tại.");
        }
        Borrower borrower = new Borrower();
        ConvertDTOToDAO.fromBorrowerDTOToBorrower(borrowerDTO);
        return borrowerRepository.save(borrower);
    }

    @Override
    public Set<Borrower> getAllByIdTraffic(Integer idTraffic) {
        Optional<Traffic> traffic = trafficRepository.findById(idTraffic);
        Set<Borrower> borrowers = new HashSet<>(borrowerRepository.findAllByTraffic(idTraffic));
        if(borrowers.isEmpty()){
            throw new NotFoundException("No borrower");
        }
        return borrowers;
    }

    @Override
    public Borrower editById(BorrowerDTO borrowerDTO, Integer idBorrower) {
        Borrower borrower = borrowerRepository.findById(idBorrower).get();
        if(borrower != null){
            throw new NotFoundException("No borrower");
        }
        return borrowerRepository.save(ConvertDTOToDAO.fromBorrowerDTOToBorrower(borrowerDTO));
    }

    @Override
    public Borrower deleteById(Integer idBorrower) {
        Optional<Borrower> borrower = borrowerRepository.findById(idBorrower);
        if(borrower.isEmpty()){
            throw new NotFoundException("No Borrower");
        }
        borrowerRepository.deleteById(idBorrower);
        return null;
    }

}
