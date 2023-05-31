package com.mustehssuniqbal.expensesbookkeeping.domain.reminder;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.DayOfWeek;

@Entity
@Getter
@Setter
public class WeeklyReminder extends ReminderDecorator {
    private Integer day;    //TODO change to DayOfWeek

    @Override
    public void remindDecoration() {
        //TODO
    }
}
