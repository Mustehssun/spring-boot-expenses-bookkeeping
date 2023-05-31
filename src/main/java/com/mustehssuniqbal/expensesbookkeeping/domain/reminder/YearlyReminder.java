package com.mustehssuniqbal.expensesbookkeeping.domain.reminder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class YearlyReminder extends ReminderDecorator {
    private Integer day;
    private Integer month;

    @Override
    public void remindDecoration() {
        //TODO
    }
}
