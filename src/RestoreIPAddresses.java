import java.util.LinkedList;
import java.util.List;

public class RestoreIPAddresses {
    static public List<String> restoreIpAddresses(String s) {
        List<String> res = new LinkedList<String>();

        helper(s,0,4,res);

        return res;
    }

    static public void helper (String s, int spiltIdx, int remain, List<String> res) {

    }

    public static void main(String [ ] args) {
        String s = "25525511135";

        List<String> ss = restoreIpAddresses(s);

        for (String string : ss) {
            System.out.println(string);
        }
    }
}
