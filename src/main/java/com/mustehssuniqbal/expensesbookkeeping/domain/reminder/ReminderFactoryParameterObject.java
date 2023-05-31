package com.mustehssuniqbal.expensesbookkeeping.domain.reminder;

import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;

@Getter
@Setter
public class ReminderFactoryParameterObject {
    private Boolean isWeekly = false;
    private Boolean isMonthly = false;
    private Boolean isDaily = false;
    private Boolean isYearly = false;
    private Boolean isOneTime = false;
    private Boolean isEmail = false;
    private Boolean isSms = false;
    private Boolean isNotification = false;
    private Boolean isSnoozable = false;
    private Integer day;
    private Integer hour;
    private Integer minute;
    private Integer second;
    private Integer monthlyDate;
    private Integer month;
}
