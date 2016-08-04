public class MinSubstringCoverAllinSet {
    static public int find (String s1, String s2) {
        int [] needToFound = new int [26];
        int [] hasToFound = new int [26];

        for (char c :s2.toCharArray()) {
            needToFound[c-'a']++;
        }

        int min = Integer.MAX_VALUE;
        int count = 0;
        for (int begin=0,end=0;end < s1.length();end++) {
            char e = s1.charAt(end);
            if (e == ' ' || needToFound[e-'a'] == 0) {
                continue;
            }
            hasToFound[e-'a']++;
            if (hasToFound[e-'a'] <= needToFound[e-'a']) {
                count++;
            }

            if (count == s2.length()) {
                while (begin<end) {
                    char b = s1.charAt(begin);
                    if (b == ' ') {
                        begin++;
                        continue;
                    }

                    if (!(needToFound[b-'a'] == 0 || hasToFound[b-'a'] > needToFound[b-'a'])) {
                        break;
                    }
                    if (hasToFound[b-'a'] > needToFound[b-'a']) {
                        hasToFound[b-'a']--;
                    }
                    begin++;
                }

                if (end-begin+1 < min) {
                    min = end-begin+1;
                }
            }
        }

        return min;
    }

    public static void main(String [ ] args) {

        // t stri
        System.out.println(find("this is a test string", "tist"));
    }
}
