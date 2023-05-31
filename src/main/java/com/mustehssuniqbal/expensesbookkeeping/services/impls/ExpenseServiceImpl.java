package com.mustehssuniqbal.expensesbookkeeping.services.impls;

import com.mustehssuniqbal.expensesbookkeeping.domain.Expense;
import com.mustehssuniqbal.expensesbookkeeping.domain.Receipt;
import com.mustehssuniqbal.expensesbookkeeping.domain.reminder.ReminderFactory;
import com.mustehssuniqbal.expensesbookkeeping.domain.reminder.ReminderFactoryParameterObject;
import com.mustehssuniqbal.expensesbookkeeping.repositories.ExpenseRepository;
import com.mustehssuniqbal.expensesbookkeeping.repositories.ReceiptRepository;
import com.mustehssuniqbal.expensesbookkeeping.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private ReceiptRepository receiptRepository;

    @Override
    public Expense createExpense(Expense expense, ReminderFactoryParameterObject reminderParams) {
        expense.setIsDeleted(false);
        expense.setReminder(ReminderFactory.create(reminderParams));

        return expenseRepository.save(expense);
    }

    @Override
    public Expense updateExpense(Long id, Expense expense) {
        Optional<Expense> existingExpense = expenseRepository.findById(id);
        if(!existingExpense.isPresent()) {
            throw new RuntimeException("Expense does not exist.");
        }
        expense.setId(id);

        return expenseRepository.save(expense);
    }

    @Override
    public Optional<Expense> getExpense(Long id) {
        return expenseRepository.findById(id);
    }

    @Override
    public List<Expense> getExpenses() {
        return expenseRepository.findAllUndeleted();
    }

    @Override
    @Transactional
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    @Override
    public Receipt pay(Long id, Receipt receipt) {
        Optional<Expense> expense = expenseRepository.findById(id);
        if(!expense.isPresent()) {
            throw new RuntimeException("Expense does not exist");
        }
        receipt.setExpense(expense.get());

        return receiptRepository.save(receipt);
    }

    @Override
    public Optional<Receipt> getReceipt(Long id) {
        return receiptRepository.findById(id);
    }

    @Override
    public List<Receipt> getReceipts() {
        return receiptRepository.findAll();
    }

    @Override
    public List<Receipt> getReceiptsOfExpense(Long expenseId) {
        return receiptRepository.findByExpenseId(expenseId);
    }
}
