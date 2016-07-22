import java.util.LinkedList;
import java.util.List;

public class LimitOutputFortheNames {
    static public String printNames(String [] names, int len) {
        StringBuilder sb = new StringBuilder();

        int charLen = 0;
        int curI = -1;
        for (int i=0;i<names.length;i++) {
            if (charLen + names[i].length() <= len) {
                sb.append(names[i]+", ");
                charLen += names[i].length();
            } else {
                curI = i;
                break;
            }
        }

        if (sb.length() > 0) {
            if (curI == -1) {
                sb.delete(sb.length()-2, sb.length());
                sb.insert(sb.length()-names[names.length-1].length()-1, "and");
                sb.append(".");
            } else {
                sb.append("and "+ (names.length-curI) +" others.");
            }
        }

        return sb.toString();
    }

    public static void main(String [ ] args) {
        String [] names = new String [] {
                "alice", "bob", "clark", "andrew", "Mike"
        };

        System.out.println(printNames(names, 52));
    }
}
