package com.ustyn.courseproject.validation.age;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class AgeConstraintValidator implements ConstraintValidator<InPast, LocalDate> {

    @Override
    public boolean isValid(LocalDate date, ConstraintValidatorContext constraintValidatorContext) {
        if (date == null) {
            return false;
        }
        return date.isBefore(LocalDate.now());
    }
}
