package com.mustehssuniqbal.expensesbookkeeping.domain.reminder;

import javax.persistence.Entity;

@Entity
public class SnoozableReminder extends ReminderDecorator {
    @Override
    public void remindDecoration() {

    }
}
