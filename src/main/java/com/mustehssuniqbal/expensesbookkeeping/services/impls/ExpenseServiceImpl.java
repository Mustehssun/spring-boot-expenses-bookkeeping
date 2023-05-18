package com.mustehssuniqbal.expensesbookkeeping.services.impls;

import com.mustehssuniqbal.expensesbookkeeping.domain.Expense;
import com.mustehssuniqbal.expensesbookkeeping.repositories.ExpenseRepository;
import com.mustehssuniqbal.expensesbookkeeping.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    @Autowired
    private ExpenseRepository repository;

    @Override
    public Expense createExpense(Expense expense) {
        return repository.save(expense);
    }

    @Override
    public Expense updateExpense(Long id, Expense expense) {
        Optional<Expense> existingExpense = repository.findById(id);
        if(!existingExpense.isPresent()) {
            throw new RuntimeException("Expense does not exist.");
        }
        expense.setId(id);

        return repository.save(expense);
    }

    @Override
    public Optional<Expense> getExpense(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Expense> getExpenses() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void deleteExpense(Long id) {
        repository.deleteById(id);
    }
}
