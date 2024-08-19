package utilitaires;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailRegex {
    // la regex pour valider l'email
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\\\.[A-Za-z]{2,}$";

    //La methode de validation
    public static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
