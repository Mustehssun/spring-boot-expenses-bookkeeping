package com.mustehssuniqbal.expensesbookkeeping.controllers;

import com.mustehssuniqbal.expensesbookkeeping.domain.Expense;
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
}
