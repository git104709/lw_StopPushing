package com.lunwei.lw_StopPushing.utils;

import com.lunwei.lw_StopPushing.enums.ResultEnum;
import com.lunwei.lw_StopPushing.exception.CodeMessageException;
import org.springframework.validation.BindingResult;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Iterator;
import java.util.Set;

/**
 * ClassName:    ValidatorUtil
 * Package:    com.lunwei.lw_StopPushing.utils
 * Description:
 * Datetime:    2020/1/17   15:40
 * Author:   zhoukaishun
 */
public class ValidatorUtil {
    public ValidatorUtil() {
    }

    public static void valid(BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            throw new CodeMessageException(ResultEnum.PARAMS_INVALID.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
    }

    public static void valid(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> set = e.getConstraintViolations();
        Iterator var2 = set.iterator();
        if (var2.hasNext()) {
            ConstraintViolation constraintViolation = (ConstraintViolation)var2.next();
            throw new CodeMessageException(constraintViolation.getMessage());
        }
    }

    public static void secureValid(BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            int code = Integer.parseInt(bindingResult.getFieldError().getCode());
            String message = bindingResult.getFieldError().getDefaultMessage();
            throw new CodeMessageException(code, message);
        }
    }
}
