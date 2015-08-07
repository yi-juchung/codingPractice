import java.util.HashMap;

public class ValidAnagram {
    static public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character,Integer> check = new HashMap<Character, Integer>();

        for(Character c : s.toCharArray()) {
            if (check.containsKey(c)) {
                check.put(c,check.get(c)+1);
            } else {
                check.put(c,1);
            }
        }

        for(Character c : t.toCharArray()) {
            if (check.containsKey(c) && check.get(c) > 0) {
                check.put(c,check.get(c)-1);
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String [ ] args) {
        String s = "anagram";
        String s2 = "nagaram";

        System.out.println(isAnagram(s,s2));
    }
}
