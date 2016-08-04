import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FindWordInMatrix {
    static public List<String> findWord(char [][] matrix, Set<String> dict) {
        boolean [][] visited = new boolean [matrix.length][matrix[0].length];
        List<String> res = new LinkedList<>();

        int maxLen = 0;
        for (String s : dict) {
            if (s.length() > maxLen) {
                maxLen = s.length();
            }
        }

        for (int i=0;i<matrix.length;i++) {
            for (int j=0;j<matrix.length;j++) {
                helper(matrix,visited,i,j,new StringBuilder(),dict, res, maxLen);
            }
        }

        return res;
    }

    static public void helper (char [][] matrix, boolean [][] visited, int i, int j, StringBuilder cur, Set<String> dict, List<String> res, int max) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || visited[i][j] || cur.length() == max) {
            return;
        }

        visited[i][j] = true;
        int len = cur.length();
        cur.append(matrix[i][j]);
        if (dict.contains(cur.toString())) {
            res.add(cur.toString());
        }

        helper(matrix,visited,i+1,j,cur,dict,res,max);
        helper(matrix,visited,i-1,j,cur,dict,res,max);
        helper(matrix,visited,i,j+1,cur,dict,res,max);
        helper(matrix,visited,i,j-1,cur,dict,res,max);
        helper(matrix,visited,i+1,j+1,cur,dict,res,max);
        helper(matrix,visited,i-1,j-1,cur,dict,res,max);
        helper(matrix,visited,i+1,j-1,cur,dict,res,max);
        helper(matrix,visited,i-1,j+1,cur,dict,res,max);

        cur.deleteCharAt(len);
        visited[i][j] = false;
    }

    public static void main(String [ ] args) {
        char [][] m = new char [][] {
                {'d','b','c','d','e'},
                {'a','o','c','d','e'},
                {'e','b','g','d','e'},
                {'a','b','c','d','e'},
                {'a','b','c','d','e'}
        };

        Set<String> dict = new HashSet<>();
        dict.add("god");
        dict.add("be");

        for (String s : findWord(m,dict)) {
            System.out.println(s);
        }
    }
}
