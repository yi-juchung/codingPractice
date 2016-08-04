import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {

    static public void dfs (String word, String end, List<String> seq, List<List<String>> res, Map<String,Integer> map) {
        if (map.get(word) == map.get(end) && !word.equals(end)) {
            return;
        } else if (word.equals(end)) {
            List<String> newSeq = new ArrayList<>(seq);
            newSeq.add(word);
            Collections.reverse(newSeq);
            res.add(newSeq);
            return;
        }

        seq.add(word);

        char [] chars = word.toCharArray();
        for (int i=0;i<word.length();i++) {
            char c = chars[i];
            for (char j = 'a'; j <= 'z'; j++) {
                if (c == j)
                    continue;

                chars[i] = j;
                String newS = new String(chars);
                chars[i] = c;
                if(map.containsKey(newS) && map.get(newS) == (map.get(word) - 1))
                    dfs(newS, end, seq, res,map);
            }
        }

        seq.remove(word);
    }

    static public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> res = new LinkedList<>();
        Map<String,Integer> map = new HashMap<>();
        Queue<String> que = new LinkedList<>();
        map.put(beginWord,1);
        que.add(beginWord);
        if (beginWord.equals(endWord)) {
            res.add(new LinkedList<String>(que));
            return res;
        }

        while (!que.isEmpty()) {
            String s = que.poll();
            char [] chars = s.toCharArray();
            for (int i=0;i<s.length();i++) {
                char c = chars[i];
                for(char j='a'; j<='z'; j++){
                    if (c == j)
                        continue;

                    chars[i] = j;
                    String newS = new String(chars);
                    chars[i] = c;
                    if (newS.equals(endWord)) {
                        map.put(newS, map.get(s)+1);
                        i = s.length();
                        que.clear();
                        break;
                    }

                    if (wordList.contains(newS) && !map.containsKey(newS)) {
                        map.put(newS, map.get(s)+1);
                        que.add(newS);
                    }
                }
            }
        }

        if (map.containsKey(endWord)) {
            dfs(endWord,beginWord,new LinkedList<>(), res, map);
        }

        return res;
    }

    public static void main(String [ ] args) {
        Set<String> dict = new LinkedHashSet<String>(){
            {
                add("hot");add("dot");add("dog");add("lot");add("log");
            }
        };

        for (List<String> list : findLadders("hit","cog",dict)) {
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println();
        }
    }
}
