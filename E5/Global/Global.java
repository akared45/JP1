package E5.Global;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Global {
    public Global() {
    }

    public static boolean ignoreCase(String preg, String str) {
        Pattern pattern = Pattern.compile(Pattern.quote(preg), 2);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}
