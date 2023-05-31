package com.mustehssuniqbal.expensesbookkeeping.domain.reminder;

import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;

@Getter
@Setter
public class WeeklyReminder extends ReminderDecorator {
    private DayOfWeek day;

    @Override
    public void remindDecoration() {
        //TODO
    }
}
