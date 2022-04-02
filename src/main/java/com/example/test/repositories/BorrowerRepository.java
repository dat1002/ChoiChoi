package com.example.test.repositories;

import com.example.test.models.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrower,Integer> {
    Borrower findByCodeAndTraffic(String codeUser, Integer idTraffic);
    Set<Borrower> findAllByTraffic(Integer idTraffic);
}
