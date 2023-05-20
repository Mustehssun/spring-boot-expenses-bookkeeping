package com.mustehssuniqbal.expensesbookkeeping.repositories;

import com.mustehssuniqbal.expensesbookkeeping.domain.Receipt;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceiptRepository extends CrudRepository<Receipt, Long> {
    List<Receipt>  findAll();
    List<Receipt> findByExpenseId(Long expenseId);
}
