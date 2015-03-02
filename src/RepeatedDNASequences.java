import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RepeatedDNASequences {
    static public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new LinkedList<String>();

        if (s.length() < 10) {
            return res;
        }

        Map<Integer,Integer> cands = new HashMap<Integer, Integer>();

        int i = 0;
        char [] charArray = s.toCharArray();
        while(i+9 < charArray.length) {
            int iKey = strToInt(charArray, i);
            if (cands.containsKey(iKey)) {
                cands.put(iKey,cands.get(iKey)+1);
            } else {
                cands.put(iKey,1);
            }

            i++;
        }

        for (Map.Entry<Integer,Integer> mapEntry : cands.entrySet()) {
            if (mapEntry.getValue() > 1) {
                res.add(intToStr(mapEntry.getKey()));
            }
        }

        return res;
    }

    public static String intToStr (int input) {
        StringBuilder sb = new StringBuilder();

        int i=0;
        while(i<10) {
            switch (input & 3) {
                case 0:
                    sb.append('A');
                    break;
                case 1:
                    sb.append('C');
                    break;
                case 2:
                    sb.append('G');
                    break;
                case 3:
                    sb.append('T');
                    break;
            }
            i++; input >>= 2;
        }

        sb.reverse();

        return sb.toString();
    }

    public static int strToInt (char [] charArray, int idx) {
        int seq = 0;

        for (int i = idx;i<idx+10;i++) {
            char c = charArray[i];
            seq <<= 2;

            switch (c) {
                case 'A' :
                    seq |= 0;
                    break;
                case 'C' :
                    seq |= 1;
                    break;
                case 'G' :
                    seq |= 2;
                    break;
                case 'T' :
                    seq |= 3;
                    break;
            }
        }

        return seq;
    }

    public static void main(String [ ] args) {
        for (String s : findRepeatedDnaSequences("GAGAGAGAGAGA")) {
            System.out.println(s);
        }
    }
}
