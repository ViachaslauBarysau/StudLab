package by.barysau.util.validator.impl;

import by.barysau.util.validator.Validator;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SizeValidator implements Validator {
    @Override
    public boolean validate(Object fileSize) {

        log.info("Size validation in progress...");

        if (((Long) fileSize) <= 2097152) {
            return true;
        }
        return false;
    }
}
