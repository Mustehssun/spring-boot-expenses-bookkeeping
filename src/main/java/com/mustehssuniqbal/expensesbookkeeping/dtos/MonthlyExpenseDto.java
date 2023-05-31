package com.mustehssuniqbal.expensesbookkeeping.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MonthlyExpenseDto extends ExpenseDto {
    private Integer monthlyPaymentDay;
}
