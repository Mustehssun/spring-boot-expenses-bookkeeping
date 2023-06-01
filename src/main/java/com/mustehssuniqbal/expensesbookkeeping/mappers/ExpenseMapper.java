package com.mustehssuniqbal.expensesbookkeeping.mappers;

import com.mustehssuniqbal.expensesbookkeeping.domain.Expense;
import com.mustehssuniqbal.expensesbookkeeping.domain.Receipt;
import com.mustehssuniqbal.expensesbookkeeping.dtos.ExpenseDto;
import com.mustehssuniqbal.expensesbookkeeping.dtos.ReceiptDto;
import org.springframework.stereotype.Component;

@Component
public class ExpenseMapper extends GeneralMapper {
    public Expense map(ExpenseDto dto) {
        Expense expense = new Expense();
        expense.setTitle(dto.getTitle());
        expense.setRecipientName(dto.getRecipientName());
        expense.setRelationWithRecipient(dto.getRelationWithRecipient());
        expense.setAmount(dto.getAmount());
        expense.setIsDeleted(false);

        return expense;
    }

    public ExpenseDto map(Expense expense) {
        ExpenseDto dto = new ExpenseDto();
        dto.setId(expense.getId());
        dto.setTitle(expense.getTitle());
        dto.setRecipientName(expense.getRecipientName());
        dto.setRelationWithRecipient(expense.getRelationWithRecipient());
        dto.setAmount(expense.getAmount());

        return dto;
    }

    public Receipt map(ReceiptDto dto) {
        Receipt receipt = new Receipt();
        receipt.setId(dto.getId());
        receipt.setAmountPaid(dto.getAmountPaid());
        receipt.setPaidOn(dto.getPaidOn());
        receipt.setComments(dto.getComments());
        receipt.setExpense(map(dto.getExpense()));

        return receipt;
    }

    public ReceiptDto map(Receipt receipt) {
        ReceiptDto dto = new ReceiptDto();
        dto.setId(receipt.getId());
        dto.setAmountPaid(receipt.getAmountPaid());
        dto.setPaidOn(receipt.getPaidOn());
        dto.setComments(receipt.getComments());
        dto.setExpense(map(receipt.getExpense()));

        return dto;
    }
}