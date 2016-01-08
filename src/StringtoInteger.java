public class StringtoInteger {
    static public int myAtoi(String str) {
        int res = 0;

        boolean pos = true;
        boolean hasDigit = false;
        boolean hasSigned = false;
        for (char c : str.toCharArray()) {
            if (c == ' ') {
                if (hasDigit || hasSigned) {
                    break;
                }
                continue;
            } else if (c == '-' || c == '+'){
                if (hasSigned) {
                    return 0;
                } else {
                    pos = (c == '+');
                    hasSigned = true;
                }
            } else {
                int nxt = c-'0';

                if (!(nxt >= 0 && nxt < 10)) {
                    break;
                }

                if (!hasDigit) {
                    res += nxt;
                    hasDigit = true;
                } else {
                    if (res >= 1000000000) {
                        if (pos) {
                            return Integer.MAX_VALUE;
                        } else {
                            return Integer.MIN_VALUE;
                        }
                    }

                    res *= 10;

                    if (res+nxt < 0) {
                        if (pos) {
                            return Integer.MAX_VALUE;
                        } else {
                            return Integer.MIN_VALUE;
                        }
                    }

                    res += nxt;
                }
            }
        }

        return (pos)?res:-res;
    }

    public static void main(String [ ] args) {

        System.out.print(myAtoi("    10522545459"));

        System.out.print(myAtoi("-2147483647"));
    }
}
