import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    static public int ladderLength(String start, String end, Set<String> dict) {
        Queue<String> queue = new LinkedList<String>();
        queue.add(start);
        queue.add("");

        int res = 1;
        while (!queue.isEmpty()) {
            String curWord = queue.poll();

            if (curWord.length() != 0) {
                char [] curChars = curWord.toCharArray();

                for (int i=0;i<curChars.length;i++) {
                    char temp = curChars[i];
                    for (char c='a';c<='z';c++) {
                        if (c == temp) continue;
                        curChars[i] = c;
                        String newWord = new String(curChars);
                        if (newWord.equals(end)) {
                            return res+1;
                        }

                        if (dict.contains(newWord)) {
                            dict.remove(newWord);
                            queue.add(newWord);
                        }
                    }
                    curChars[i] = temp;
                }
            } else if (!queue.isEmpty()) {
                res++;
                queue.add("");
            }
        }
        return 0;
    }

    public static void main(String [ ] args) {
        Set<String> dict = new LinkedHashSet<String>(){
            {
                add("hot");add("dot");add("dog");add("lot");add("log");
            }
        };
//        Set<String> dict = new LinkedHashSet<String>(){
//            {
//                add("a");add("b");add("c");
//            }
//        };

        System.out.print(ladderLength("hit","cog",dict));
    }
}
