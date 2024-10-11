package E10.Validation;

import java.util.regex.Pattern;

public class OrderValidation {
    private static final String ID_REGEX = "^(ORDPM)[0-9]{8}$";
    private static final Pattern ID_PATTERN = Pattern.compile(ID_REGEX);

    public static boolean validateId(String id) {
        return ID_PATTERN.matcher(id).matches();
    }
}
