import java.util.LinkedList;
import java.util.List;

public class FlipGame {

    public static List<String> count(String s) {
        List<String> ll = new LinkedList<>();

        int i = 0;
        char [] a = s.toCharArray();
        for (;i+1<a.length;i++) {
            if (a[i] == '+' && a[i+1] == '+') {
                a[i] = '-';
                a[i+1] = '-';
                ll.add(new String(a));
                a[i] = '+';
                a[i+1] = '+';
            }
        }

        return ll;
    }

    public static void main(String [ ] args) {
        String s = "++++";
        List<String> l = count(s);

        for (String ss : l) {
            System.out.println(ss);
        }
    }
}
