package com.example.repo;

import com.example.entity.AddMoneyPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddMoneyPaymentRepo extends JpaRepository<AddMoneyPayment,Long> {

    AddMoneyPayment findByPgTxnId(String pgTxnId);
}
