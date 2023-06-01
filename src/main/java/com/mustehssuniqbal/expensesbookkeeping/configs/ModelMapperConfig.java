package com.mustehssuniqbal.expensesbookkeeping.configs;

import com.mustehssuniqbal.expensesbookkeeping.domain.Expense;
import com.mustehssuniqbal.expensesbookkeeping.dtos.ExpenseDto;
import com.mustehssuniqbal.expensesbookkeeping.mappers.ExpenseMapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper
        .getConfiguration()
        .setFieldMatchingEnabled(true)
        .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
        .setAmbiguityIgnored(true);

        mapper
        .typeMap(ExpenseDto.class, Expense.class)
        .addMappings(mapping -> mapping.skip(Expense::setReminder));

        return mapper;
    }
}
