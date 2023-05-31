package com.mustehssuniqbal.expensesbookkeeping.domain.reminder;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class YearlyReminder extends ReminderDecorator {
    private Integer monthlyDate;
    private Integer month;

    @Override
    public void remindDecoration() {
        //TODO
    }
}
