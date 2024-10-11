package E10.Validation;

import java.util.regex.Pattern;
public class CustomerValidation {
    private static final String NAME_REGEX = "^[a-zA-Z\\s]{3,50}$";
    private static final Pattern NAME_PATTERN = Pattern.compile(NAME_REGEX);

    public static boolean validateName(String name) {
        return NAME_PATTERN.matcher(name).matches();
    }

    public static boolean validateId(int id) {
        return id > 0;
    }
}
