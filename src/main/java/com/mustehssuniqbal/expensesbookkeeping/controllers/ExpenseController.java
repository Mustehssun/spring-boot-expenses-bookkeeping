package com.mustehssuniqbal.expensesbookkeeping.controllers;

import com.mustehssuniqbal.expensesbookkeeping.domain.Expense;
import com.mustehssuniqbal.expensesbookkeeping.domain.Receipt;
import com.mustehssuniqbal.expensesbookkeeping.domain.reminder.ReminderFactoryParameterObject;
import com.mustehssuniqbal.expensesbookkeeping.dtos.ExpenseDto;
import com.mustehssuniqbal.expensesbookkeeping.dtos.ReceiptDto;
import com.mustehssuniqbal.expensesbookkeeping.mappers.ExpenseMapper;
import com.mustehssuniqbal.expensesbookkeeping.mappers.GeneralMapper;
import com.mustehssuniqbal.expensesbookkeeping.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    @Autowired
    private ExpenseService service;

    @Resource(name = "expenseMapper")
    private ExpenseMapper mapper;

    @PostMapping("/")
    public ResponseEntity<ExpenseDto> createExpense(@RequestBody ExpenseDto expenseDto) {
        Expense mappedExpense = mapper.map(expenseDto);
        ReminderFactoryParameterObject mappedReminder = mapper.map(expenseDto.getReminder(), ReminderFactoryParameterObject.class);
        Expense expense = service.createExpense(mappedExpense, mappedReminder);

        return ResponseEntity.ok(mapper.map(expense));
    }

    @PostMapping("/{id}")
    public ResponseEntity<ExpenseDto> updateExpense(@PathVariable Long id, @RequestBody ExpenseDto expenseDto) {
        Expense expense = service.updateExpense(id, mapper.map(expenseDto, Expense.class));

        return ResponseEntity.ok(mapper.map(expense));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseDto> getExpense(@PathVariable Long id) {
        Optional<Expense> expense = service.getExpense(id);
        ExpenseDto mappedExpense = expense.map(value -> mapper.map(value)).orElse(null);

        return ResponseEntity.of(Optional.ofNullable(mappedExpense));
    }

    @GetMapping("/")
    public ResponseEntity<List<ExpenseDto>> getExpenses() {
        List<Expense> expenses = service.getExpenses();
        List<ExpenseDto> expenseDtos = expenses.stream().map(expense -> mapper.map(expense)).collect(Collectors.toList());

        return ResponseEntity.ok(expenseDtos);
    }

    @PostMapping("/{id}/delete")
    public ResponseEntity<?> deleteExpense(@PathVariable Long id) {
        service.deleteExpense(id);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/pay")
    public ResponseEntity<ReceiptDto> pay(@PathVariable Long id, @RequestBody ReceiptDto receiptDto) {
        Receipt receipt = service.pay(id, mapper.map(receiptDto));

        return ResponseEntity.ok(mapper.map(receipt));
    }

    @GetMapping("/receipts/{id}")
    public ResponseEntity<ReceiptDto> getReceipt(@PathVariable Long id) {
        Optional<Receipt> receipt = service.getReceipt(id);
        ReceiptDto receiptDto = receipt.map(value -> mapper.map(value)).orElse(null);

        return ResponseEntity.of(Optional.ofNullable(receiptDto));
    }

    @GetMapping("/receipts/")
    public ResponseEntity<List<ReceiptDto>> getReceipts() {
        List<Receipt> receipts = service.getReceipts();
        List<ReceiptDto> receiptDtos = receipts.stream().map(receipt -> mapper.map(receipt)).collect(Collectors.toList());

        return ResponseEntity.ok(receiptDtos);
    }

    @GetMapping("/{id}/receipts/")
    public ResponseEntity<List<ReceiptDto>> getReceiptsOfExpense(@PathVariable Long id) {
        List<Receipt> receipts = service.getReceiptsOfExpense(id);
        List<ReceiptDto> receiptDtos = receipts.stream().map(receipt -> mapper.map(receipt)).collect(Collectors.toList());

        return ResponseEntity.ok(receiptDtos);
    }
}
