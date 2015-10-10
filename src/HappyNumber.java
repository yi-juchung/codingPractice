import java.util.HashSet;

public class HappyNumber {
    static public boolean isHappy(int n) {
        HashSet<Integer> visited = new HashSet<Integer>();

        return isHappyRecur(n,visited);
    }

    static public boolean isHappyRecur(int n, HashSet<Integer> visited) {

        int sum = 0;

        while (n != 0) {
            int base = n%10;
            sum += base*base;
            n /= 10;
        }

        if (sum == 1)
            return true;

        if (visited.contains(sum))
            return false;

        visited.add(sum);

        return isHappyRecur(sum,visited);
    }

    public static void main(String [ ] args) {
        System.out.println(isHappy(19));
    }
}
