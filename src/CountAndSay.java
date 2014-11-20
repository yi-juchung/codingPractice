public class CountAndSay {
    static public String countAndSay(int n) {
        String prev = "1";

        while (n-1 > 0) {
            StringBuilder tempSb = new StringBuilder();
            char prevChar = ' ';
            int count = 0;
            for(int i = 0;i<prev.length();i++) {
                if (prevChar != prev.charAt(i)) {
                    if (count != 0) {
                        tempSb.append(count);
                        tempSb.append(prevChar);
                    }
                    prevChar = prev.charAt(i);
                    count = 1;
                } else {
                    count++;
                }
            }

            tempSb.append(count);
            tempSb.append(prevChar);

            prev = tempSb.toString();

            n--;
        }

        return prev;
    }

    public static void main(String [ ] args) {
        System.out.print(countAndSay(2));
    }
}
