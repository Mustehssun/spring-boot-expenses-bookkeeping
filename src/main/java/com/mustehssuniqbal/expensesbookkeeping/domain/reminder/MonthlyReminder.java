package com.mustehssuniqbal.expensesbookkeeping.domain.reminder;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class MonthlyReminder extends ReminderDecorator {
    private Integer monthlyDate;

    @Override
    public void remindDecoration() {
        //TODO
    }
}