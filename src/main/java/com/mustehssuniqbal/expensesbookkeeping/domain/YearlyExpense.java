package com.mustehssuniqbal.expensesbookkeeping.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class YearlyExpense extends Expense {
    private Date scheduledDate;
}
