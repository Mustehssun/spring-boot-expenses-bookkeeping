package com.mustehssuniqbal.expensesbookkeeping.dtos;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.mustehssuniqbal.expensesbookkeeping.domain.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpenseDto {
    private Long id;
    private String title;
    private String recipientName;
    private String relationWithRecipient;
    private Double amount;
    private ReminderDto reminder;
    private User user;
}
