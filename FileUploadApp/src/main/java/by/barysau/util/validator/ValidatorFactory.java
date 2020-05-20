package by.barysau.util.validator;

import by.barysau.util.validator.impl.NameValidator;
import by.barysau.util.validator.impl.SizeValidator;
import by.barysau.util.validator.impl.TypeValidator;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ValidatorFactory {

    public static Validator validatorCreate(int validatorType) {
        final int SIZE_VALIDATOR = 1;
        final int TYPE_VALIDATOR = 2;
        final int NAME_VALIDATOR = 3;

        switch (validatorType) {
            case (SIZE_VALIDATOR): {
                log.debug("Size validator created.");
                return new SizeValidator();
            }
            case (TYPE_VALIDATOR): {
                log.debug("Type validator created.");
                return new TypeValidator();
            }
            case (NAME_VALIDATOR): {
                log.debug("Name validator created.");
                return new NameValidator();
            }
            default: {
                log.warn("Unknown validator exception!");
                throw new RuntimeException("This validator is unknown!");
            }
        }
    }
}
