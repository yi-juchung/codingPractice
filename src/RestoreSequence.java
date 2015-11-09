import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class RestoreSequence {

    static class People {
        int height;
        int tvalue;

        People(int h, int t) {
            height = h;
            tvalue = t;
        }
    }

    static public List<People> restore(People [] peoples) {
        HashMap<Integer,List<People>> map = new HashMap<Integer, List<People>>();

        for (People p : peoples) {
            List<People> anchor;
            if (map.containsKey(p.tvalue)) {
                anchor = map.get(p.tvalue);
            } else {
                anchor = new LinkedList<People>();
            }

            anchor.add(p);
            map.put(p.tvalue, anchor);
        }

        List<People> res = map.get(0);
        Collections.sort(res, new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                return o1.height-o2.height;
            }
        });

        int higher = 1;
        while (res.size() < peoples.length) {
            if (!map.containsKey(higher)) {
                higher++;
                continue;
            }

            List<People> cur = map.get(higher);
            Collections.sort(cur, new Comparator<People>() {
                @Override
                public int compare(People o1, People o2) {
                    return o1.height-o2.height;
                }
            });

            for (People p : cur) {
                int count = 0;
                int i=0;
                for (;i<res.size();i++) {
                    if (res.get(i).height > p.height) {
                        if (count == higher) {
                            break;
                        } else {
                            count++;
                        }
                    }
                }

                res.add(i,p);
            }

            higher++;
        }

        return res;
    }

    public static void main(String [ ] args) {
        People [] inputs = new People[6];

        // 15,13,20,4,7,19

        inputs[0] = new People(4,3);
        inputs[1] = new People(19,1);
        inputs[2] = new People(20,0);
        inputs[3] = new People(15,0);
        inputs[4] = new People(13,1);
        inputs[5] = new People(7,3);


        for(People p : restore(inputs)) {
            System.out.println(p.height);
        }

        // 9,3,20,12,17,4

        inputs[0] = new People(3,1);
        inputs[1] = new People(9,0);
        inputs[2] = new People(20,0);
        inputs[3] = new People(12,1);
        inputs[4] = new People(17,1);
        inputs[5] = new People(4,4);


        for(People p : restore(inputs)) {
            System.out.println(p.height);
        }
    }
}
