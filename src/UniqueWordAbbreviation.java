import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class UniqueWordAbbreviation {

    public static class Dict {
        HashMap<String,Set<Integer>> dictMap;

        public Dict(String [] dict) {
            dictMap = new HashMap<>();
            for (String s : dict) {
                if (s.length() < 2)
                    continue;

                char [] chars = s.toCharArray();
                String key = new StringBuilder().append(chars[0]).append(chars[-1]).toString();
                Set<Integer> inner;
                if (dictMap.containsKey(key)) {
                    inner = dictMap.get(key);
                } else {
                    inner = new HashSet<>();
                }

                inner.add(s.length());
            }
        }

        public boolean isUnique(String s) {
            if (s.length() < 2)
                return true;

            char [] chars = s.toCharArray();
            String key = new StringBuilder().append(chars[0]).append(chars[-1]).toString();
            if (!dictMap.containsKey(key))
                return true;

            return !dictMap.get(key).contains(s.length());
        }
    }



    public static void main(String [ ] args) {
        String [] dictionary = new String[] {"deer", "door", "cake", "card"};

        Dict d = new Dict(dictionary);

        System.out.println(d.isUnique("dear"));
        System.out.println(d.isUnique("cart"));
        System.out.println(d.isUnique("cane"));
        System.out.println(d.isUnique("make"));
    }
}
