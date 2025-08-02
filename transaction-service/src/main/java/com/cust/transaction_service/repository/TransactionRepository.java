package com.cust.transaction_service.repository;




import com.cust.transaction_service.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {
    // You can add custom queries later, like findByCustomerId
    List<Transaction> findByCustomerId(String customerId);
}

