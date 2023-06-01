package com.mustehssuniqbal.expensesbookkeeping.utils;

import com.mustehssuniqbal.expensesbookkeeping.domain.reminder.ReminderDecorator;
import org.hibernate.Hibernate;

public class HibernateUtils {
    public static boolean isSubclassOf(ReminderDecorator reminder, Class<?> type) {
        if(reminder == null) {  //edge case
            return false;
        }
        return type.getSimpleName().equals(Hibernate.getClass(reminder).getSimpleName());
    }
}
