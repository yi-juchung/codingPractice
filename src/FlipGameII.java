import java.util.List;

public class FlipGameII {
    static public boolean canWin(String s) {
        for (int i=0;i<s.length()-1;i++) {
            if ((s.charAt(i) == '+' && s.charAt(i+1) == '+') && !canWin(s.substring(0,i)+"--"+s.substring(i+2))) {
                return true;
            }
        }

        return false;
    }

    public static void main(String [ ] args) {
        System.out.println(canWin("++++++"));
        System.out.println(canWin("++++"));
    }
}
