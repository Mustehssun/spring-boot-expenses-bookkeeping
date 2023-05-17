package com.mustehssuniqbal.expensesbookkeeping.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GeneralMapper {
    @Autowired
    private ModelMapper mapper;

    public <T> T map(Object source, Class<T> destinationType) {
        return mapper.map(source, destinationType);
    }
}
