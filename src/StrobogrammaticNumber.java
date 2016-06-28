public class StrobogrammaticNumber {

    static public boolean isStro(char c, char c2) {
        switch (c) {
            case '1':
                return c2 =='1';
            case '6':
                return c2 == '9';
            case '8':
                return c2 == '8';
            case '0':
                return c2 == '0';
            case '9':
                return c2 == '6';
            default:
                return false;
        }
    }

    static public boolean isStrobo(String s) {
        char [] chars = s.toCharArray();

        int i=0;
        int j=chars.length-1;

        while (i < j) {
            if (!isStro(chars[i],chars[j])) {
                return false;
            }
            i++;j--;
        }

        return true;
    }

    public static void main(String [ ] args) {
        System.out.println(isStrobo("118"));

    }
}
