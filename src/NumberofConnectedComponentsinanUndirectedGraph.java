import java.util.HashSet;
import java.util.Set;

public class NumberofConnectedComponentsinanUndirectedGraph {

    // union-find
    static public int countComponents(int n, int[][] edges) {

        int [] group = new int [n];

        for (int i=0;i<group.length;i++) {
            group[i] = i;
        }

        for (int [] edge : edges) {
            union(group,edge[0],edge[1]);
        }

        Set<Integer> groups = new HashSet<>();
        for (int i : group) {
            groups.add(find(group,i));
        }

        return groups.size();
    }

    static public void union(int [] group, int i, int j) {
        group[find(group,i)] = find(group,j);
    }

    static public int find(int [] group, int i) {

        if (group[i] == i)
            return i;

        group[i] = find(group,group[i]);
        return group[i];
    }

//    BFS
//    static public int countComponents(int n, int[][] edges) {
//        List<Integer> [] adj = new List[n];
//
//        for (int i=0;i<adj.length;i++) {
//            adj[i] = new LinkedList<>();
//        }
//
//        for (int [] edge : edges) {
//            int from = edge[0];
//            int to = edge[1];
//
//            adj[from].add(to);
//            adj[to].add(from);
//        }
//
//        boolean [] visited = new boolean[n];
//        Queue<Integer> queue = new LinkedList<>();
//        int res = 0;
//        for (int i=0;i<n;i++) {
//            if (!visited[i]) {
//                res++;
//                queue.add(i);
//                processQueue(adj, visited,queue);
//            }
//        }
//
//        return res;
//    }
//
//    static public void visit(int v, List<Integer> [] adj, boolean [] visited, Queue<Integer> queue) {
//        visited[v] = true;
//        queue.addAll(adj[v]);
//    }
//
//    static public void processQueue(List<Integer> [] adj, boolean [] visited, Queue<Integer> queue) {
//        while (!queue.isEmpty()) {
//            int v = queue.poll();
//
//            if (!visited[v]) {
//                visit(v,adj,visited,queue);
//            }
//        }
//    }

//    DFS
//    static public int countComponents(int n, int[][] edges) {
//        List<Integer> [] adj = new List[n];
//
//        for (int i=0;i<adj.length;i++) {
//            adj[i] = new LinkedList<>();
//        }
//
//        for (int [] edge : edges) {
//            int from = edge[0];
//            int to = edge[1];
//
//            adj[from].add(to);
//            adj[to].add(from);
//        }
//
//        boolean [] visited = new boolean[n];
//        int res = 0;
//        for (int i=0;i<n;i++) {
//            if (!visited[i]) {
//                res++;
//                visit(i, adj, visited);
//            }
//        }
//
//        return res;
//    }
//
//    static public void visit(int v, List<Integer> [] adj, boolean [] visited) {
//        if (visited[v])
//            return;
//
//        visited[v] = true;
//
//        for (int i : adj[v]) {
//            if (!visited[i]) {
//                visit(i, adj,visited);
//            }
//        }
//    }

    public static void main(String [ ] args) {
        int [][] edges = new int [][] {
                {0, 1},
                {1, 2},
                {3, 4}
        };

        System.out.println(countComponents(5,edges));

        edges = new int [][] {
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 4}
        };

        System.out.println(countComponents(5,edges));
    }
}
