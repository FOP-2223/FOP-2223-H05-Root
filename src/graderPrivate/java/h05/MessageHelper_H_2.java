package h05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageHelper_H_2 {

    private static final char[] VOWELS = new char[]{'A', 'E', 'I', 'O', 'U'};
    private static final String MESSAGE_PATTERN = "^I am (a|an) ([aA-zZ 0-9]*).$";

    private static boolean firstCharIsVowel(String s) {
        if (s.length() < 1) {
            return false;
        }
        for (char vowel : VOWELS) {
            if (s.charAt(0) == vowel || s.charAt(0) == vowel + 32) {
                return true;
            }
        }
        return false;
    }

    public static String match_format(String s) {
        Pattern p = Pattern.compile(MESSAGE_PATTERN);
        Matcher m = p.matcher(s);
        if (!m.matches()) {
            throw new AssertionError("toString Message does not have matching format!");
        }
        return m.group(2);
    }

    private static String toNoun(String s) {
        char[] name = s.toCharArray();
        for (int i = 0; i < name.length; i++) {
            if (isSpecialCharacter(name[i])) {
                name[i] = ' ';
            } else {
                name[i] = i == 0 ? toUpper(name[i]) : toLower(name[i]);
            }
        }
        return new String(name);
    }

    private static char toUpper(char c) {
        if (c >= 'a' && c <= 'z') {
            return (char) (c - 32);
        }
        return c;
    }

    private static char toLower(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char) (c + 32);
        }
        return c;
    }

    private static boolean isSpecialCharacter(char c) {
        if ((c >= 32 & c <= 47) | (c >= 58 & c <= 64) | (c >= 91 & c <= 96) | (c >= 123 & c <= 126)) {
            return true;
        }
        return false;
    }

    public static String expected_name(String name) {
        String transportTypeString = name == null ? "undefined" : toNoun(name);
        String indefiniteArticle = firstCharIsVowel(transportTypeString) ? "an" : "a";
        return "I am " + indefiniteArticle + " " + transportTypeString + ".";
    }
}
