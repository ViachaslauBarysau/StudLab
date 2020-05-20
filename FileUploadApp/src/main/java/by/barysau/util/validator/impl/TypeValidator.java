package by.barysau.util.validator.impl;

import by.barysau.util.validator.Validator;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TypeValidator implements Validator {
    @Override
    public boolean validate(Object fileType) {

        log.info("Type validation in progress...");

        if (fileType.equals("image/jpeg") || fileType.equals("image/gif") || fileType.equals("image/png")) {
            return true;
        }
        return false;
    }
}
