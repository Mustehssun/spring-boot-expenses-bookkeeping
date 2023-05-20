package com.mustehssuniqbal.expensesbookkeeping.controllers;

import com.mustehssuniqbal.expensesbookkeeping.domain.Expense;
import com.mustehssuniqbal.expensesbookkeeping.domain.Receipt;
import com.mustehssuniqbal.expensesbookkeeping.dtos.ExpenseDto;
import com.mustehssuniqbal.expensesbookkeeping.mappers.GeneralMapper;
import com.mustehssuniqbal.expensesbookkeeping.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    @Autowired
    private ExpenseService service;

    @Autowired
    private GeneralMapper mapper;

    @PostMapping("/")
    public ResponseEntity<Expense> createExpense(@RequestBody ExpenseDto expenseDto) {
        Expense expense = service.createExpense(mapper.map(expenseDto, Expense.class));

        return ResponseEntity.ok(expense);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable Long id, @RequestBody ExpenseDto expenseDto) {
        Expense expense = service.updateExpense(id, mapper.map(expenseDto, Expense.class));

        return ResponseEntity.ok(expense);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpense(@PathVariable Long id) {
        return ResponseEntity.of(service.getExpense(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<Expense>> getExpenses() {
        return ResponseEntity.ok(service.getExpenses());
    }

    @PostMapping("/{id}/delete")
    public ResponseEntity deleteExpense(@PathVariable Long id) {
        service.deleteExpense(id);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/pay")
    public ResponseEntity<Receipt> pay(@PathVariable Long id, @RequestBody Receipt receiptDto) {
        Receipt receipt = service.pay(id, receiptDto.getAmountPaid(), receiptDto.getPaidOn());

        return ResponseEntity.ok(receipt);
    }

    @GetMapping("/receipts/{id}")
    public ResponseEntity<Receipt> getReceipt(@PathVariable Long id) {
        return ResponseEntity.of(service.getReceipt(id));
    }

    @GetMapping("/receipts/")
    public ResponseEntity<List<Receipt>> getReceipts() {
        return ResponseEntity.ok(service.getReceipts());
    }

    @GetMapping("/{id}/receipts/")
    public ResponseEntity<List<Receipt>> getReceiptsOfExpense(@PathVariable Long id) {
        return ResponseEntity.ok(service.getReceiptsOfExpense(id));
    }
}
