package com.mustehssuniqbal.expensesbookkeeping.repositories;

import com.mustehssuniqbal.expensesbookkeeping.domain.Expense;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long> {
    List<Expense> findAll();

    @Query("select expense from Expense expense where expense.isDeleted = false")
    List<Expense> findAllUndeleted();

    @Modifying
    @Query("update Expense expense set expense.isDeleted = true where expense.id = :id")
    void deleteById(@Param("id") Long id);
}
