import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphValidTree {

    static public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[1]).add(edge[0]);
            adjList.get(edge[0]).add(edge[1]);
        }

        boolean[] visited = new boolean[n];

        if (!helper(visited, 0, -1, adjList)) {
            return false;
        }

        for (int i=0;i<n;i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }

    static public boolean helper(boolean [] v, int cur, int from, List<List<Integer>> adj) {
        if (v[cur]) {
            return false;
        }

        v[cur] = true;

        List<Integer> neighbors = adj.get(cur);

        for (int i : neighbors) {
            if (i != from && !helper(v,i,cur,adj)) {
                return false;
            }
        }

        return true;
    }

    // BFS
//    static public boolean validTree(int n, int[][] edges) {
//        List<List<Integer>> adjList = new ArrayList<List<Integer>>();
//        for (int i = 0; i < n; i++) {
//            adjList.add(new ArrayList<Integer>());
//        }
//
//        for (int[] edge : edges) {
//            adjList.get(edge[1]).add(edge[0]);
//            adjList.get(edge[0]).add(edge[1]);
//        }
//
//        boolean[] visited = new boolean[n];
//
//        Queue<Integer> queue = new LinkedList<Integer>();
//        queue.offer(0);
//
//        while (!queue.isEmpty()) {
//            int vertexId = queue.poll();
//
//            if (visited[vertexId]) {
//                return false;
//            }
//
//            visited[vertexId] = true;
//
//            for (int neighbor : adjList.get(vertexId)) {
//                if (!visited[neighbor]) {
//                    queue.offer(neighbor);
//                }
//            }
//        }
//
//        for (boolean v : visited) {
//            if (!v) {
//                return false;
//            }
//        }
//
//        return true;
//    }

    public static void main(String [ ] args) {
        int [][] edges = new int[][] {
                {0,1},
                {1,2},
                {2,3},
                {1,3},
                {1,4}
        };

        // false
        System.out.println(validTree(5, edges));

        edges = new int[][] {
                {0,1},
                {0,2},
                {0,3},
                {1,4}
        };

        // true
        System.out.println(validTree(5, edges));

        edges = new int[][] {
                {0,1},
                {1,2},
                {3,4}
        };

        // false
        System.out.println(validTree(5, edges));
    }
}
