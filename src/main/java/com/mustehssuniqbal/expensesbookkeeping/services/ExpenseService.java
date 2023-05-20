package com.mustehssuniqbal.expensesbookkeeping.services;

import com.mustehssuniqbal.expensesbookkeeping.domain.Expense;
import com.mustehssuniqbal.expensesbookkeeping.domain.Receipt;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ExpenseService {
    Expense createExpense(Expense expense);
    Expense updateExpense(Long id, Expense expense);
    Optional<Expense> getExpense(Long id);
    List<Expense> getExpenses();
    void deleteExpense(Long id);
    Receipt pay(Long id, Double amountPaid, Date paidOn);
    Optional<Receipt> getReceipt(Long id);
    List<Receipt> getReceipts();
    List<Receipt> getReceiptsOfExpense(Long expenseId);
}
