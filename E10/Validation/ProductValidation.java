package E10.Validation;

import java.util.regex.Pattern;

public class ProductValidation {
    private static final String ID_REGEX = "^(MS|NE|SE)[0-9]{6}$";
    private static final Pattern ID_PATTERN = Pattern.compile(ID_REGEX);

    private static final String NAME_REGEX = "^[a-zA-Z\\s]+$";
    private static final Pattern NAME_PATTERN = Pattern.compile(NAME_REGEX);

    public static boolean validateId(String id) {
        return ID_PATTERN.matcher(id).matches();
    }

    public static boolean validateName(String name) {
        return NAME_PATTERN.matcher(name).matches();
    }

    public static boolean validateQuantity(int quantity) {
        return quantity >= 0;
    }
}
