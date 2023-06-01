package com.mustehssuniqbal.expensesbookkeeping.dtos;

import com.mustehssuniqbal.expensesbookkeeping.domain.Expense;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ReceiptDto {
    private Long id;
    private Double amountPaid;
    private Date paidOn;
    private String comments;
    private ExpenseDto expense;
}
