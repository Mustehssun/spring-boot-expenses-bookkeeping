package com.mustehssuniqbal.expensesbookkeeping.dtos;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.mustehssuniqbal.expensesbookkeeping.domain.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpenseDto {
    private String title;
    private String recipientName;
    private String relationWithRecipient;
    private Double amount;
    private User user;
}
