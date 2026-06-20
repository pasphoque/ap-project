package enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Command {
    REGISTER("(?i)^\\S*register\\s+-u\\s+(?<username>\\S+)\\s+-p\\s+(?<password>\\S+)\\s+(?<passwordConfirm>\\S+)\\s+-n\\s+(?<nickname>\\S+)\\s+-e\\s+(?<email>\\S+)\\s+-g\\s+(?<gender>\\S+)\\S*$"),
    LOGIN("(?i)^\\S*login\\s+-u\\s+(?<username>\\S+)\\s+-p\\s+(?<password>\\S+)(?<stayLoggedIn>\\s+-stay-logged-in)?\\S*$"),
    MENU_ENTER("(?i)^\\S*menu\\s+enter\\s+(?<menuName>.+)\\S*$"),
    MENU_EXIT("(?i)^\\S*menu\\s+exit\\S*$"),
    MENU_LOGOUT("(?i)^\\S*menu\\s+logout\\S*$"),
    UNKNOWN("");

    private final Pattern pattern;

    Command(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    public Matcher getMatcher(String input) {
        return pattern.matcher(input);
    }
}