public class CountAndSayInPlace {
    static String countAndSay(String s) {
        if (s.length() < 1)
            return "";

        char [] chars = s.toCharArray();
        int len = 0;

        int count = 1;
        char curChar = chars[0];
        for (int i=1;i<chars.length;i++) {
            char nextChar = chars[i];
            if (curChar == nextChar) {
                count++;
            } else {
                len += 1+numDigits(count);
                count = 1;
            }
            curChar = nextChar;
        }

        len += 1+numDigits(count);
        int newIdx=0;
        if (len > s.length()) {
            // no way
            return "";
        } else {
            count = 1;
            curChar = chars[0];
            for (int i=1;i<chars.length;i++) {
                char nextChar = chars[i];
                if (curChar == nextChar) {
                    count++;
                } else {
                    chars[newIdx] = curChar;
                    newIdx++;
                    if (count != 1) {
                        char [] nums = convertInt(count);
                        for (int j=0;j<nums.length;j++) {
                            chars[newIdx+j] = nums[j];
                        }

                        newIdx += nums.length;
                    }

                    count = 1;
                }
                curChar = nextChar;
            }

            chars[newIdx] = curChar;
            newIdx++;
            if (count != 1) {
                char [] nums = convertInt(count);
                for (int j=0;j<nums.length;j++) {
                    chars[newIdx+j] = nums[j];
                }

                newIdx += nums.length;
            }
        }
        newIdx--;
        int lastIdx = len-1;
        // final update for 1 char
        boolean hasNum = false;
        while (newIdx >= 0) {
            if (Character.isDigit(chars[newIdx])) {
                hasNum = true;
            } else if (hasNum){
                hasNum = false;
            } else {
                chars[lastIdx--] = '1';
            }
            chars[lastIdx] = chars[newIdx];
            newIdx--;
            lastIdx--;
        }

        return new String(chars).substring(0,len);
    }

    static char [] convertInt(int count) {
        return Integer.toString(count).toCharArray();
    }

    static int numDigits(int num) {
        if (num < 10)
            return 1;
        if (num < 100)
            return 2;
        if (num < 1000)
            return 3;
        if (num < 10000)
            return 4;
        if (num < 100000)
            return 5;
        if (num < 1000000)
            return 6;
        if (num < 10000000)
            return 7;
        if (num < 100000000)
            return 8;
        if (num < 1000000000)
            return 9;
        if (num <= Integer.MAX_VALUE)
            return 10;
        return 0;
    }

    public static void main(String [ ] args) {
        System.out.print(countAndSay("messyyyaaaa"));
    }
}
