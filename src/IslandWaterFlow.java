import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IslandWaterFlow {

    public static List<Pair> find(int [][] island) {
        int [][] visited = new int[island.length][island[0].length];
        List<Pair> res = new LinkedList<Pair>();
        Queue<Pair> calc = new LinkedList<Pair>();
        calc.add(new Pair(0,0));
        for (int i=1;i<island.length;i++) {
            calc.add(new Pair(i,0));
            calc.add(new Pair(0,i));
        }

        helper(island, calc, visited, 1, -1, 1, res);

        calc.add(new Pair(island.length-1, island[0].length-1));
        for (int i=1;i<island.length;i++) {
            calc.add(new Pair(island.length-1-i,island[0].length-1));
            calc.add(new Pair(island.length-1,island[0].length-1-i));
        }

        helper(island, calc, visited, 2, 1, -1, res);

        return res;
    }

    public static void helper(int [][] island, Queue<Pair> calc, int [][] visited, int mark, int target, int direct, List<Pair> res) {
        while(!calc.isEmpty()) {
            Pair<Integer,Integer> p = calc.poll();
            int i = p.getKey();
            int j = p.getValue();
            if (visited[i][j] == target) {
                res.add(new Pair(i,j));
            } else if (visited[i][j] == mark) {
                continue;
            }

            int height = island[i][j];

            if (isValid(height,island,i+direct,j)) {
                calc.add(new Pair(i+direct,j));
            }

            if (isValid(height,island,i,j+direct)) {
                calc.add(new Pair(i,j+direct));
            }

            visited[i][j] = mark;
        }
    }

    public static boolean isValid(int height, int [][] island, int tox, int toy) {
        return (tox >= 0 && tox < island.length) &&
                (toy >= 0 && toy < island[0].length) &&
                island[tox][toy] >= height;
    }

    public static void main(String [ ] args) {

        int [][] island = new int [][] {
                {1,4,7,5,3},
                {0,2,10,3,1},
                {4,5,3,11,0},
                {2,13,15,1,2},
                {12,2,3,1,4}
        };

        for (Pair p : find(island)) {
            System.out.println(p.getKey()+","+p.getValue());
        }
    }
}
