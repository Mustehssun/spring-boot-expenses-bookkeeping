package com.mustehssuniqbal.expensesbookkeeping.domain;

import com.mustehssuniqbal.expensesbookkeeping.domain.reminder.ReminderDecorator;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String recipientName;
    private String relationWithRecipient;
    private Double amount;

    @OneToOne
    private ReminderDecorator reminder;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private User user;

    private Boolean isDeleted;
}
