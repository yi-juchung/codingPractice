import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CourseScheduleII {
    static int take = 0;
    static public int[] findOrder(int numCourses, int[][] prerequisites) {
        Course [] result = new Course[numCourses];
        int [] res = new int[numCourses];
        for (int i=0;i<numCourses;i++) {
            result[i] = new Course(i);
        }

        for (int i=0;i<prerequisites.length;i++) {
            result[prerequisites[i][0]].add(result[prerequisites[i][1]]);
        }

        for (int i=0;i<numCourses;i++) {
            if (search(result[i], res)) {
                return new int [0];
            }
        }

        return res;
    }

    static public boolean search (Course cur, int [] res) {
        if (cur.taken) {
            return false;
        } else if (cur.cycle) {
            return true;
        }

        cur.cycle = true;

        for (Course c : cur.require) {
            if (search(c, res)) {
                return true;
            }
        }

        cur.taken = true;
        cur.cycle = false;
        res[take++] = cur.value;
        return false;
    }

    static public class Course {
        boolean taken = false;
        boolean cycle = false;
        int value;
        List<Course> require = new LinkedList<>();

        public Course (int i) {
            value = i;
        }
        public void add (Course c) {
            require.add(c);
        }
    }

//    static int overall;
//
//    static public int[] findOrder(int numCourses, int[][] prerequisites) {
//        Set<Integer> visited = new HashSet<Integer>();
//        Set<Integer> cycle = new HashSet<Integer>();
//
//        int [] res = new int [numCourses];
//        Arrays.fill(res,-1);
//
//        overall = numCourses-1;
//
//        HashMap<Integer,List<Integer>> relations = new HashMap<Integer, List<Integer>>();
//
//        for (int [] i : prerequisites) {
//            if (relations.containsKey(i[1])) {
//                relations.get(i[1]).add(i[0]);
//            } else {
//                List<Integer> newList = new LinkedList<Integer>();
//                newList.add(i[0]);
//                relations.put(i[1], newList);
//            }
//        }
//
//        boolean cycleDec = false;
//        for (int i : relations.keySet()) {
//            cycleDec = travel(i, visited, cycle, relations, res);
//
//            if (cycleDec) {
//                return new int []{};
//            }
//        }
//
//        if (overall >= 0) {
//            for (int i = 0;i<numCourses;i++) {
//                if (!visited.contains(i)) {
//                    res[overall--] = i;
//                }
//            }
//        }
//
//        return res;
//    }
//
//    static public boolean travel (int cur, Set<Integer> visited, Set<Integer> cycleDetect, HashMap<Integer,List<Integer>> relations, int [] res) {
//        if (cycleDetect.contains(cur)) {
//            return true;
//        } else if (visited.contains(cur)) {
//            return false;
//        }
//
//        visited.add(cur);
//        cycleDetect.add(cur);
//
//        if (relations.containsKey(cur)) {
//            boolean cycle = false;
//            for (int i : relations.get(cur)) {
//                cycle = travel(i, visited, cycleDetect, relations, res);
//                if (cycle) {
//                    return true;
//                }
//            }
//        }
//
//        cycleDetect.remove(cur);
//        res[overall] = cur;
//        overall--;
//
//        return false;
//    }

    public static void main(String [ ] args) {

        int [][] prep = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        //int [][] prep = new int[][]{{1,0},{2,0},{3,2},{0,3}};
        //int [][] prep = new int[][]{};
        //int [][] prep = new int[][]{{1,0}};

        for(int i : findOrder(4, prep)) {
            System.out.println(i);
        }
    }
}
