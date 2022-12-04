package h05;

/**
 * Defines, which category a Vehicle belongs to
 */
public enum TransportType {
    BICYCLE, CAR, VESSEL, AIRCRAFT;

    /**
     * Converts a TransportType to the Noun representation, which means all letters, except first, which is upper case, are lower case
     * @return according Noun representation
     */
    public String toNoun() {
        char[] name = this.name().toCharArray();
        for (int i = 0; i < name.length; i++) {
            if (isSpecialCharacter(name[i])) {
                name[i] = ' ';
            } else {
                name[i] = i == 0 ? toUpper(name[i]) : toLower(name[i]);
            }
        }
        return new String(name);
    }

    /**
     *
     * @param c Input char
     * @return the according upper Letter
     */
    private char toUpper(char c) {
        if (c >= 'a' && c <= 'z') {
            return (char) (c - 32);
        }
        return c;
    }

    /**
     *
     * @param c Input char
     * @return the according lower Letter
     */
    private char toLower(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char) (c + 32);
        }
        return c;
    }

    /**
     * Checks if a letter c is a special Character
     * @param c input character
     * @return true, if c is a special char; otherwise false
     */
    private boolean isSpecialCharacter(char c) {
        if ((c >= 32 & c <= 47) | (c >= 58 & c <= 64) | (c >= 91 & c <= 96) | (c >= 123 & c <= 126)) {
            return true;
        }
        return false;
    }
}
