package com.mustehssuniqbal.expensesbookkeeping.services;

import com.mustehssuniqbal.expensesbookkeeping.domain.Expense;

import java.util.List;
import java.util.Optional;

public interface ExpenseService {
    Expense createExpense(Expense expense);
    Expense updateExpense(Long id, Expense expense);
    Optional<Expense> getExpense(Long id);
    List<Expense> getExpenses();
}
