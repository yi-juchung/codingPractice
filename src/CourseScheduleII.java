import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CourseScheduleII {

    static int overall;

    static public int[] findOrder(int numCourses, int[][] prerequisites) {
        Set<Integer> visited = new HashSet<Integer>();
        Set<Integer> cycle = new HashSet<Integer>();

        int [] res = new int [numCourses];
        Arrays.fill(res,-1);

        overall = numCourses-1;

        HashMap<Integer,List<Integer>> relations = new HashMap<Integer, List<Integer>>();

        for (int [] i : prerequisites) {
            if (relations.containsKey(i[1])) {
                relations.get(i[1]).add(i[0]);
            } else {
                List<Integer> newList = new LinkedList<Integer>();
                newList.add(i[0]);
                relations.put(i[1], newList);
            }
        }

        boolean cycleDec = false;
        for (int i : relations.keySet()) {
            cycleDec = travel(i, visited, cycle, relations, res);

            if (cycleDec) {
                return new int []{};
            }
        }

        if (overall >= 0) {
            for (int i = 0;i<numCourses;i++) {
                if (!visited.contains(i)) {
                    res[overall--] = i;
                }
            }
        }

        return res;
    }

    static public boolean travel (int cur, Set<Integer> visited, Set<Integer> cycleDetect, HashMap<Integer,List<Integer>> relations, int [] res) {
        if (cycleDetect.contains(cur)) {
            return true;
        } else if (visited.contains(cur)) {
            return false;
        }

        visited.add(cur);
        cycleDetect.add(cur);

        if (relations.containsKey(cur)) {
            boolean cycle = false;
            for (int i : relations.get(cur)) {
                cycle = travel(i, visited, cycleDetect, relations, res);
                if (cycle) {
                    return true;
                }
            }
        }

        cycleDetect.remove(cur);
        res[overall] = cur;
        overall--;

        return false;
    }

    public static void main(String [ ] args) {

        //int [][] prep = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        //int [][] prep = new int[][]{};
        int [][] prep = new int[][]{{1,0}};

        for(int i : findOrder(3, prep)) {
            System.out.println(i);
        }
    }
}
