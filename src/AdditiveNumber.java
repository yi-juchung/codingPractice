import java.math.BigInteger;

public class AdditiveNumber {
    static public boolean isAdditiveNumber(String num) {

        int len = num.length()/2+1;
        for (int i=1;i<len;i++) {
           if (num.charAt(0) == '0' && i != 1) {
               break;
           }
            BigInteger firstNum = new BigInteger(num.substring(0,i));
            for (int j=i+1;j<num.length();j++) {
                if (num.charAt(i) == '0' && j-i != 1) {
                    break;
                }

                BigInteger preNum = new BigInteger(num.substring(i,j));

                if (helper(firstNum.add(preNum), preNum, Math.max(i,j-i), num.substring(j))) {
                    return true;
                }
            }
        }

        return false;
    }

    static public boolean helper(BigInteger targetSum, BigInteger preNum, int minLen, String num) {
        if (num.length() == 0) {
            return true;
        }

        for (int i=minLen;i<=num.length();i++) {
            if (num.charAt(0) == '0' && i != 1) {
                return false;
            }

            BigInteger curNum  = new BigInteger(num.substring(0,i));

            if (targetSum.equals(curNum) && (i==num.length() || helper(preNum.add(curNum), curNum, Math.max(minLen,i), num.substring(i)))) {
                return true;
            }
        }

        return false;
    }

    public static void main(String [ ] args) {
        String s = "112358";
        // true
        System.out.println(isAdditiveNumber(s));

        s = "101";
        // true
        System.out.println(isAdditiveNumber(s));

        s = "1203";
        // false
        System.out.println(isAdditiveNumber(s));

        s = "199100199";
        // true
        System.out.println(isAdditiveNumber(s));

        s = "8019823962";
        // false
        System.out.println(isAdditiveNumber(s));

        s = "198019823962";
        // true
        System.out.println(isAdditiveNumber(s));
    }
}
