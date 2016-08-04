public class FirstBadVersion {
    static public int firstBadVersion(int n) {
        int i = 1;
        int j = n;

        while (i < j) {
            int mid = i+(j-i)/2;

            if (isBadVersion(mid)) {
                j = mid;
            } else {
                i = mid+1;
            }
        }

        return isBadVersion(i)?i:j;
    }

    static public boolean isBadVersion (int v) {
        return v >= 26;
    }

    public static void main(String [ ] args) {
        System.out.print(firstBadVersion(30));
    }
}
