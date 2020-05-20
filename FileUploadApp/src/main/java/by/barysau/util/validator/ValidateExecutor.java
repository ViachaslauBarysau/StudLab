package by.barysau.util.validator;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.Part;

@Slf4j
public class ValidateExecutor {
    public static String validateFile(Part filePart) {

        final int SIZE_VALIDATOR = 1;
        final int TYPE_VALIDATOR = 2;
        final int NAME_VALIDATOR = 3;
        String message = "";

        Validator sizeValidator = ValidatorFactory.validatorCreate(SIZE_VALIDATOR);
        Validator typeValidator = ValidatorFactory.validatorCreate(TYPE_VALIDATOR);
        Validator nameValidator = ValidatorFactory.validatorCreate(NAME_VALIDATOR);


        if (sizeValidator.validate(filePart.getSize()) == false) {
            message += "Max file size is 2Mb. ";
        }
        if (typeValidator.validate(filePart.getContentType()) == false) {
            message += "Accepted formats: .jpg, .png, .gif. ";
        }
        if (nameValidator.validate(filePart.getSubmittedFileName()) == false) {
            message += "The file with the same name already uploaded.";
        }

        return message;
    }
}
