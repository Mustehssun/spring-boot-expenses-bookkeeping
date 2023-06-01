package com.mustehssuniqbal.expensesbookkeeping.mappers;

import com.mustehssuniqbal.expensesbookkeeping.domain.Expense;
import com.mustehssuniqbal.expensesbookkeeping.domain.Receipt;
import com.mustehssuniqbal.expensesbookkeeping.domain.reminder.*;
import com.mustehssuniqbal.expensesbookkeeping.dtos.ExpenseDto;
import com.mustehssuniqbal.expensesbookkeeping.dtos.ReceiptDto;
import com.mustehssuniqbal.expensesbookkeeping.dtos.ReminderDto;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;

import static com.mustehssuniqbal.expensesbookkeeping.utils.HibernateUtils.isSubclassOf;

@Component
public class ExpenseMapper extends GeneralMapper {
    public Expense map(ExpenseDto dto) {
        Expense expense = new Expense();
        expense.setTitle(dto.getTitle());
        expense.setRecipientName(dto.getRecipientName());
        expense.setRelationWithRecipient(dto.getRelationWithRecipient());
        expense.setAmount(dto.getAmount());
        expense.setIsDeleted(false);

        return expense;
    }

    public ExpenseDto map(Expense expense) {
        ExpenseDto expenseDto = new ExpenseDto();
        expenseDto.setId(expense.getId());
        expenseDto.setTitle(expense.getTitle());
        expenseDto.setRecipientName(expense.getRecipientName());
        expenseDto.setRelationWithRecipient(expense.getRelationWithRecipient());
        expenseDto.setAmount(expense.getAmount());

        ReminderDto reminderDto = mapReminder(expense);
        expenseDto.setReminder(reminderDto);

        return expenseDto;
    }

    private ReminderDto mapReminder(Expense expense) {
        ReminderDto reminderDto = new ReminderDto();
        ReminderDecorator reminder = expense.getReminder();
        if(isSubclassOf(reminder, DailyReminder.class)) {
            reminderDto.setIsDaily(true);
        }
        else if(isSubclassOf(reminder, WeeklyReminder.class)) {
            reminderDto.setIsWeekly(true);

            WeeklyReminder weeklyReminder = (WeeklyReminder) Hibernate.unproxy(reminder);
            reminderDto.setDay(weeklyReminder.getDay());
        }
        else if(isSubclassOf(reminder, MonthlyReminder.class)) {
            reminderDto.setIsMonthly(true);

            MonthlyReminder monthlyReminder = (MonthlyReminder) Hibernate.unproxy(reminder);
            reminderDto.setDay(monthlyReminder.getMonthlyDate());
        }
        else if(isSubclassOf(reminder, YearlyReminder.class)) {
            reminderDto.setIsYearly(true);

            YearlyReminder yearlyReminder = (YearlyReminder) Hibernate.unproxy(reminder);
            reminderDto.setDay(yearlyReminder.getMonthlyDate());
            reminderDto.setMonth(yearlyReminder.getMonth());
        }
        else {
            reminderDto.setIsOneTime(true);
        }
        if(reminder != null) {
            reminderDto.setSecond(reminder.getSecond());
            reminderDto.setMinute(reminder.getMinute());
            reminderDto.setHour(reminder.getHour());
        }
        return reminderDto;
    }

    public Receipt map(ReceiptDto dto) {
        Receipt receipt = new Receipt();
        receipt.setId(dto.getId());
        receipt.setAmountPaid(dto.getAmountPaid());
        receipt.setPaidOn(dto.getPaidOn());
        receipt.setComments(dto.getComments());
        receipt.setExpense(map(dto.getExpense()));

        return receipt;
    }

    public ReceiptDto map(Receipt receipt) {
        ReceiptDto dto = new ReceiptDto();
        dto.setId(receipt.getId());
        dto.setAmountPaid(receipt.getAmountPaid());
        dto.setPaidOn(receipt.getPaidOn());
        dto.setComments(receipt.getComments());
        dto.setExpense(map(receipt.getExpense()));

        return dto;
    }
}