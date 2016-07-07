import java.util.BitSet;

public class MaximumProductofWordLengths {
    static public int maxProduct(String[] words) {
        int [] bs = new int[words.length];

        for (int i=0;i<words.length;i++) {
            String s = words[i];

            for (char c : s.toCharArray()) {
                bs[i] |= 1 << (c-'a'+1);
            }
        }

        int max = 0;
        for (int i=0;i<words.length;i++) {
            for (int j=i+1;j<words.length;j++) {
                if (!inter(bs[i],bs[j])) {
                    if (words[i].length()*words[j].length() > max) {
                        max = words[i].length()*words[j].length();
                    }
                }
            }
        }

        return max;
    }

    static public boolean inter(int i, int j) {
        for (int k=0;k<26;k++) {
            if (((i&1) & (j&1)) == 1) {
                return true;
            }
            i >>= 1;
            j >>= 1;
        }

        return false;
    }


    public static void main(String [ ] args) {

        String [] words = new String []{
                "abcw", "baz", "foo", "bar", "xtfn", "abcdef"
        };

        System.out.println(maxProduct(words));

        words = new String []{
                "a", "ab", "abc", "d", "cd", "bcd", "abcd"
        };

        System.out.println(maxProduct(words));

        words = new String []{
                "a", "aa", "aaa", "aaaa"
        };

        System.out.println(maxProduct(words));
    }
}
