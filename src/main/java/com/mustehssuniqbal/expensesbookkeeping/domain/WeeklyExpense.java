package com.mustehssuniqbal.expensesbookkeeping.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;

@Getter
@Setter
public class WeeklyExpense extends Expense {
    private DayOfWeek scheduledDayOfTheWeek;
}
