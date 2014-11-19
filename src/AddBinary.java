public class AddBinary {
    static public String addBinary(String a, String b) {
        if (a == null || a.length() < 1)
            return b;
        if (b == null || b.length() < 1)
            return a;

        if (a.length() < b.length()) {
            String c = a;
            a = b;
            b = c;
        }

        int i = a.length()-1;
        int j = b.length()-1;
        StringBuilder sb = new StringBuilder();

        boolean carry = false;
        while(i >= 0 && j >= 0) {
            if (a.charAt(i) == b.charAt(j)) {
                sb.insert(0,carry?'1':'0');

                carry = a.charAt(i) == '1';
            } else {
                sb.insert(0,carry?'0':'1');
            }
            i--; j--;
        }

        while (i>= 0) {
            if (a.charAt(i) == '1') {
                sb.insert(0,carry?'0':'1');
            } else {
                sb.insert(0,carry?'1':'0');

                if (carry)
                    carry = !carry;
            }

            i--;
        }

        if (carry) {
            sb.insert(0,'1');
        }

        return sb.toString();
    }

    public static void main(String [ ] args) {
        System.out.print(addBinary("1010", "1011"));
    }
}
