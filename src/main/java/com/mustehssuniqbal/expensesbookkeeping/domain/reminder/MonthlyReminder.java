package com.mustehssuniqbal.expensesbookkeeping.domain.reminder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MonthlyReminder extends ReminderDecorator {
    private Integer monthlyDate;

    @Override
    public void remindDecoration() {
        //TODO
    }
}
