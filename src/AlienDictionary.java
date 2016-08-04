import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AlienDictionary {
    static public String alien(String [] strings) {
        Map<Character,Set<Character>> graph = new HashMap<>();

        for (String s : strings) {
            for (int i=s.length()-1;i>0;i--) {
                char from = s.charAt(i-1);
                char to = s.charAt(i);

                if (from == to)
                    continue;

                if (graph.containsKey(from)) {
                    graph.get(from).add(to);
                } else {
                    graph.put(from, new HashSet<Character>(){{ add(to); }});
                }

                if (!graph.containsKey(to)) {
                    graph.put(to,new HashSet<>());
                }
            }
        }

        Set<Character> visited = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (char c : graph.keySet()) {
            if (!visited.contains(c)) {
                if (topSort(c,graph,visited,new HashSet<>(),sb)) {
                    return "";
                }
            }
        }

        return sb.length() == graph.keySet().size()?sb.toString():"";
    }

    static public boolean topSort (char c, Map<Character,Set<Character>> graph, Set<Character> visited, Set<Character> loop, StringBuilder sb) {
        if (loop.contains(c)) {
            return true;
        }

        if (visited.contains(c)) {
            return false;
        }

        loop.add(c);
        visited.add(c);

        for (char d : graph.get(c)) {
            if (topSort(d,graph,visited,loop,sb)) {
                return true;
            }
        }

        loop.remove(c);
        sb.insert(0,c);
        return false;
    }

    public static void main(String [ ] args) {
        String [] dict = {
                "wrt", "wrf", "er", "ett", "rftt"
        };

        System.out.println(alien(dict));
    }
}
