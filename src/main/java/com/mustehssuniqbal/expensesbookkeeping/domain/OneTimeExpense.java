package com.mustehssuniqbal.expensesbookkeeping.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OneTimeExpense extends Expense {
    private Date scheduledDate;
}
