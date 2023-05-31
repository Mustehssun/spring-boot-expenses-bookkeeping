package com.mustehssuniqbal.expensesbookkeeping.domain.reminder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ReminderDecorator {
    protected Integer second;
    protected Integer minute;
    protected Integer hour;

    private ReminderDecorator decorator;

    public abstract void remindDecoration();

    public void remind() {
        remindDecoration();
        if(decorator != null) {
            decorator.remind();
        }
    }
}
