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
                return isNumberHelper(s);
            }
        }
    }

    static public boolean firstPart(String firstPart) {

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
                return isNumberHelper(parts[0]);
            } else {
                return false;
            }
        } else {
            int nextIdx = 0;

            while(nextIdx < parts[0].length()) {
                char nextChar = parts[0].charAt(nextIdx);
                if (nextChar == '+' || nextChar == '-')
                    nextIdx++;
                else
                    break;
            }

            if (nextIdx < parts[0].length()) {
                if (parts[0].charAt(nextIdx) == '0' && nextIdx+1 == parts[0].length() ) {
                    return isNumberHelper(parts[1]);
                } else {
                    return isNumberHelper(parts[0]) && isNumberHelper(parts[1]);
                }
            } else {
                return false;
            }
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
        System.out.print(isNumber("0e"));
    }
}
