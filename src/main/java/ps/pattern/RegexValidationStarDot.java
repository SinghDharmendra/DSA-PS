package ps.pattern;


class RegexValidationStarDot {

    static boolean isMatch(String text, String pattern) {
        // your code goes here

        return isMatchRec(text, pattern, 0, 0);
    }

    static boolean isMatchRec(String text, String pattern, int textIdx, int patIdx) {
        int patLen = pattern.length();
        int textLen = text.length();

        if (textIdx >= text.length()) {
            if (patIdx >= pattern.length())
                return true;
            else if (patIdx < pattern.length() - 1 && pattern.charAt(patIdx + 1) == '*') {
                return isMatchRec(text, pattern, textIdx, patIdx + 2);
            } else {
                return false;
            }
        }

        if (patIdx >= pattern.length() && textIdx < text.length())
            return false;

        else if (patIdx < patLen - 1 && pattern.charAt(patIdx + 1) == '*') {
            char pchar = pattern.charAt(patIdx);
            char tchar = text.charAt(textIdx);
            if (pchar == '.' || pchar == tchar)
                return (isMatchRec(text, pattern, textIdx, patIdx + 2) ||
                        isMatchRec(text, pattern, textIdx + 1, patIdx));
            else
                return isMatchRec(text, pattern, textIdx, patIdx + 2);

        } else if (pattern.charAt(patIdx) == '.' || pattern.charAt(patIdx) == text.charAt(textIdx)) {
            return isMatchRec(text, pattern, textIdx + 1, patIdx + 1);
        } else
            return false;

    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {

        }

    }

}
