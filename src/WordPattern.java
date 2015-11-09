import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class WordPattern {
    static public boolean wordPattern(String pattern, String str) {
        HashMap<Character,String> to = new HashMap<Character, String>();
        Set<String> occured = new HashSet<String>();

        String [] splitString = str.split(" ");
        if (splitString.length != pattern.length())
            return false;

        for (int i=0;i<splitString.length;i++) {
            Character c = pattern.charAt(i);
            if (to.containsKey(c)) {
                if (!to.get(c).equals(splitString[i])) {
                    return false;
                }
            } else {
                if (occured.contains(splitString[i]))
                    return false;
                to.put(c,splitString[i]);
                occured.add(splitString[i]);
            }
        }

        return true;
    }

    public static void main(String [ ] args) {
        //System.out.print(wordPattern("abba", "dog cat cat dog"));
        System.out.print(wordPattern("aaaa", "dog dog dog dog"));
    }
}
