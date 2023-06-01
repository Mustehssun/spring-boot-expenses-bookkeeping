package com.mustehssuniqbal.expensesbookkeeping.domain.reminder;

import static com.mustehssuniqbal.expensesbookkeeping.utils.BooleanUtils.defaultIfNull;

public class ReminderFactory {
    public static ReminderDecorator create(ReminderFactoryParameterObject params) {
        ReminderDecorator reminder = createTimelyReminder(params);
        if(defaultIfNull(params.getIsEmail(), false)) {
            EmailReminder emailReminder = new EmailReminder();
            emailReminder.setDecorator(reminder);

            reminder = emailReminder;
        }
        if(defaultIfNull(params.getIsNotification(), false)) {
            NotificationReminder notificationReminder = new NotificationReminder();
            notificationReminder.setDecorator(reminder);

            reminder = notificationReminder;
        }
        if(defaultIfNull(params.getIsSms(), false)) {
            SmsReminder smsReminder = new SmsReminder();
            smsReminder.setDecorator(reminder);

            reminder = smsReminder;
        }
        if(defaultIfNull(params.getIsSnoozable(), false)) {
            SnoozableReminder snoozableReminder = new SnoozableReminder();
            snoozableReminder.setDecorator(reminder);

            reminder = snoozableReminder;
        }
        return reminder;
    }

    private static ReminderDecorator createTimelyReminder(ReminderFactoryParameterObject params) {
        ReminderDecorator reminder;
        if(defaultIfNull(params.getIsDaily(), false)) {
            DailyReminder dailyReminder = new DailyReminder();
            setTime(params, dailyReminder);

            reminder = dailyReminder;
        }
        else if(defaultIfNull(params.getIsWeekly(), false)) {
            WeeklyReminder weeklyReminder = new WeeklyReminder();
            setTime(params, weeklyReminder);

            weeklyReminder.setDay(params.getDay());

            reminder = weeklyReminder;
        }
        else if(defaultIfNull(params.getIsMonthly(), false)) {
            MonthlyReminder monthlyReminder = new MonthlyReminder();
            setTime(params, monthlyReminder);

            monthlyReminder.setMonthlyDate(params.getMonthlyDate());

            reminder = monthlyReminder;
        }
        else if(defaultIfNull(params.getIsYearly(), false)) {
            YearlyReminder yearlyReminder = new YearlyReminder();
            setTime(params, yearlyReminder);

            yearlyReminder.setMonthlyDate(params.getMonthlyDate());
            yearlyReminder.setMonth(params.getMonth());

            reminder = yearlyReminder;
        }
        else {
            reminder = new OneTimeReminder();
        }
        return reminder;
    }

    private static void setTime(ReminderFactoryParameterObject params, ReminderDecorator reminder) {
        reminder.setHour(params.getHour());
        reminder.setMinute(params.getMinute());
        reminder.setSecond(params.getSecond());
    }
}
