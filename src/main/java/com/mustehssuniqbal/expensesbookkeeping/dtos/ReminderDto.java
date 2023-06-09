package com.mustehssuniqbal.expensesbookkeeping.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReminderDto {
    private Boolean isWeekly;
    private Boolean isMonthly;
    private Boolean isDaily;
    private Boolean isYearly;
    private Boolean isOneTime;
    private Boolean isEmail;
    private Boolean isSms;
    private Boolean isNotification;
    private Boolean isSnoozable;
    private Integer day;
    private Integer hour;
    private Integer minute;
    private Integer second;
    private Integer monthlyDate;
    private Integer month;
}
