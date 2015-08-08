import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class CourseScheduleII {

    static public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> relation = new HashMap<Integer, List<Integer>>();
        Set<Integer> courses = new HashSet<Integer>();
        for (int i=0;i<numCourses;i++) {
            courses.add(i);
        }
        Set<Integer> visited = new HashSet<Integer>();
        Queue<Integer> visitedSeq = new LinkedList<Integer>();
        Set<Integer> cycleDetect = new HashSet<Integer>();

        for(int [] pair : prerequisites) {
            if (relation.containsKey(pair[1])) {
                relation.get(pair[1]).add(pair[0]);
            } else {
                List<Integer> newList = new LinkedList<Integer>();
                newList.add(pair[0]);
                relation.put(pair[1], newList);
            }
        }

        for(int key : relation.keySet()) {

            boolean cycle = false;
            if (!visited.contains(key)) {
                cycleDetect.add(key);
                cycle = travel(key, visited, cycleDetect, relation, visitedSeq);
            }

            if (cycle)
                return new int []{};
        }

        List<Integer> res = new LinkedList<Integer>(visitedSeq);
        courses.removeAll(visited);
        res.addAll(courses);

        int [] aws = new int [res.size()];
        for (int i=0;i<numCourses;i++) {
            aws[i] = res.get(i);
        }

        return aws;
    }

    static public boolean travel (int cur, Set<Integer> visited, Set<Integer> cycleDetect, HashMap<Integer,List<Integer>> relation, Queue<Integer> visitedSeq) {
        if (cycleDetect.contains(cur))
            return true;

        if (visited.contains(cur)) {
            return false;
        }

        visited.add(cur);
        visitedSeq.add(cur);

        if (relation.containsKey(cur)) {
            List<Integer> nextRound = relation.get(cur);

            for (int i : nextRound) {
                cycleDetect.add(i);
                boolean cycle = travel(i, visited, cycleDetect, relation, visitedSeq);
                cycleDetect.remove(i);
                if (cycle)
                    return true;
            }
        }

        return false;
    }

    public static void main(String [ ] args) {

        int [][] prep = new int[][]{{1,0},{2,0},{3,1},{3,2}};

        for(int i : findOrder(4, prep)) {
            System.out.println(i);
        }
    }
}
