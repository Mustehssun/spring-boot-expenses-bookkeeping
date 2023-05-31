package com.mustehssuniqbal.expensesbookkeeping.domain.reminder;

public class ReminderFactory {
    public static ReminderDecorator create(ReminderFactoryParameterObject params) {
        ReminderDecorator reminder = createTimelyReminder(params);
        if(params.getIsEmail()) {
            EmailReminder emailReminder = new EmailReminder();
            emailReminder.setDecorator(reminder);

            reminder = emailReminder;
        }
        if(params.getIsNotification()) {
            NotificationReminder notificationReminder = new NotificationReminder();
            notificationReminder.setDecorator(reminder);

            reminder = notificationReminder;
        }
        if(params.getIsSms()) {
            SmsReminder smsReminder = new SmsReminder();
            smsReminder.setDecorator(reminder);

            reminder = smsReminder;
        }
        if(params.getIsSnoozable()) {
            SnoozableReminder snoozableReminder = new SnoozableReminder();
            snoozableReminder.setDecorator(reminder);

            reminder = snoozableReminder;
        }
        return reminder;
    }

    private static ReminderDecorator createTimelyReminder(ReminderFactoryParameterObject params) {
        ReminderDecorator reminder;
        if(params.getIsDaily()) {
            DailyReminder dailyReminder = new DailyReminder();
            setTime(params, dailyReminder);

            reminder = dailyReminder;
        }
        if(params.getIsWeekly()) {
            WeeklyReminder weeklyReminder = new WeeklyReminder();
            setTime(params, weeklyReminder);

            weeklyReminder.setDay(params.getDay());

            reminder = weeklyReminder;
        }
        if(params.getIsMonthly()) {
            MonthlyReminder monthlyReminder = new MonthlyReminder();
            setTime(params, monthlyReminder);

            monthlyReminder.setMonthlyDate(params.getMonthlyDate());

            reminder = monthlyReminder;
        }
        if(params.getIsYearly()) {
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
