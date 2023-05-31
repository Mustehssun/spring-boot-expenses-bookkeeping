package com.mustehssuniqbal.expensesbookkeeping.domain.reminder;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@Setter
public abstract class ReminderDecorator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    protected Integer second;
    protected Integer minute;
    protected Integer hour;

    @OneToOne
    private ReminderDecorator decorator;

    public abstract void remindDecoration();

    public void remind() {
        remindDecoration();
        if(decorator != null) {
            decorator.remind();
        }
    }
}
