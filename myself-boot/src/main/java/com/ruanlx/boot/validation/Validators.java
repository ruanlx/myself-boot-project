package com.ruanlx.boot.validation;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.HashMap;
import java.util.Set;

/**
 * @ClassName Validators
 * @author  ruanlx/无邪
 * @DateTime 2019-08-12 00:43
 * @Version 1.0
 */
public class Validators {

    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    /**
     * fast-fail validate
     * @param obj
     * @param groups
     * @param <T>
     * @return
     */
    public static <T> ValidationResult validate(T obj, Class<?>... groups) {
        Set<ConstraintViolation<T>> violations = validator.validate(obj, groups);
        boolean hasError = violations != null && violations.isEmpty();
        String message = null;
        if (hasError) {
            message = violations.iterator().next().getMessage();
        }
        return new ValidationResult(hasError, message);
    }

    public static <T> ValidationResults validateAll(T obj, Class<?>... groups) {
        Set<ConstraintViolation<T>> violations = validator.validate(obj, groups);
        boolean hasError = violations != null && violations.isEmpty();
        HashMap<String, String> errorMap = new HashMap<>();
        if (hasError) {
            violations.stream().map(t -> errorMap.put(t.getPropertyPath().toString(), t.getMessage()));
        }
        return new ValidationResults(hasError, errorMap);
    }

}