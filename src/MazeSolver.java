import com.sun.tools.javac.util.Pair;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MazeSolver {
    static public void solver (char [][] m) {
        boolean [][] visited = new boolean[m.length][m[0].length];
        Pair [][] parent = new Pair[m.length][m[0].length];

        for (int i=0;i<m.length;i++) {
            for (int j=0;j<m[i].length;j++) {
                if (m[i][j] == 'X') {
                    helper(m, visited, i, j, parent);
                    break;
                }
            }
        }
    }

    static public void helper (char [][] m, boolean [][] visited, int i, int j, Pair [][] parent) {
        Queue<Pair<Integer,Integer>> que = new LinkedList<>();
        que.add(new Pair<>(i,j));

        while (!que.isEmpty()) {
            Pair<Integer,Integer> p = que.poll();

            if (visited[p.fst][p.snd]) {
                continue;
            }

            visited[p.fst][p.snd] = true;

            if (m[p.fst][p.snd] == 'O') {
                m[p.fst][p.snd] = '+';
                Pair<Integer,Integer> par = parent[p.fst][p.snd];
                while (!(par.fst == i && par.snd == j)) {
                    m[par.fst][par.snd] = '+';
                    par = parent[par.fst][par.snd];
                }
                m[par.fst][par.snd] = '+';
                break;
            }

            if (p.fst > 0 && !visited[p.fst-1][p.snd] && m[p.fst-1][p.snd] != '#') {
                parent[p.fst-1][p.snd] = p;
                que.add(new Pair<>(p.fst-1,p.snd));
            }
            if (p.fst < m.length-1 && !visited[p.fst+1][p.snd] && m[p.fst+1][p.snd] != '#') {
                parent[p.fst+1][p.snd] = p;
                que.add(new Pair<>(p.fst+1,p.snd));
            }
            if (p.snd < m[0].length-1 && !visited[p.fst][p.snd+1] && m[p.fst][p.snd+1] != '#') {
                parent[p.fst][p.snd+1] = p;
                que.add(new Pair<>(p.fst,p.snd+1));
            }
            if (p.snd > 0 && !visited[p.fst][p.snd-1] && m[p.fst][p.snd-1] != '#') {
                parent[p.fst][p.snd-1] = p;
                que.add(new Pair<>(p.fst,p.snd-1));
            }
        }
    }


    public static void main(String [ ] args) {
        /*
        ##########
        X  #     #
        #  #  #  #
        #     #  O
        ##########
         */

        BufferedReader br = null;

        try {
            int rowCount = 0;
            String sCurrentLine;

            br = new BufferedReader(new FileReader(args[0]));
            List<String> temp = new LinkedList<>();
            while ((sCurrentLine = br.readLine()) != null) {
                rowCount++;
                temp.add(sCurrentLine);
            }

            int colCount = temp.get(0).length();

            char [][] matrix = new char [rowCount][colCount];
            int i =0;
            for (String s : temp) {
                matrix[i++] = s.toCharArray();
            }

            solver(matrix);

            for (i=0;i<matrix.length;i++) {
                System.out.println(new String(matrix[i]));
            }

        } catch (Exception ex) {
            // blah
            return;
        }
    }
}
