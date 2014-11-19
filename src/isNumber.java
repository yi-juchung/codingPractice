/*
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
".1" => true
"3." => true
"e1" => false
"3e" => false
"0.." => false
"0e" => false
"-0." => true
"-01" => true
"+.8" => true
 */

public class isNumber {
    static public boolean isNumber(String s) {
        if (s == null)
            return false;
        s = s.trim();

        if (s.length() < 1) {
            return false;
        } else {
            if (s.contains(".")) {
                String [] parts = s.split("\\.", -1);

                return checkParts(parts, '.');
            } else if (s.contains("e")) {
                String [] parts = s.split("e", -1);

                return checkParts(parts, 'e');
            } else {
                return checkFirstPart(s);
            }
        }
    }

    static public boolean checkParts(String [] parts, char spliter) {
        if (parts.length != 2) {
            return false;
        } else if (parts[0].length() < 1) {
            if (spliter == '.') {
                if (parts[1].length() < 1)
                    return false;
                else
                    return isNumberHelper(parts[1]);
            } else {
                return false;
            }
        } else if (parts[1].length() < 1) {
            if (spliter == '.') {
                return checkFirstPart(parts[0]);
            } else {
                return false;
            }
        } else {
            return checkFirstPart(parts[0]) && isNumberHelper(parts[1]);
        }
    }

    static public boolean checkFirstPart(String s) {
        int nextIdx = 0;

        boolean firstOccur = false;
        while(nextIdx < s.length()) {
            char nextChar = s.charAt(nextIdx);
            if (nextChar == '+' || nextChar == '-') {
                nextIdx++;
                if (firstOccur) {
                    return false;
                } else
                    firstOccur = true;
            } else
                break;
        }

        if (nextIdx < s.length()) {
            return isNumberHelper(s.substring(nextIdx));
        } else {
            return isNumberHelper(s);
        }
    }

    static public boolean isNumberHelper(String s) {
        if (s.length() < 1)
            return true;

        if (s.charAt(0) < 58 && s.charAt(0) > 47) {
            return isNumberHelper(s.substring(1));
        } else {
            return false;
        }
    }

    public static void main(String [ ] args) {
        System.out.print(isNumber("-1."));
    }
}
