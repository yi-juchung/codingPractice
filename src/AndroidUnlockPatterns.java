public class AndroidUnlockPatterns {
    static public int numberOfPatterns(int m, int n) {
        boolean [] selected = new boolean[10];
        int [][] jump = new int[10][10];
        jump[1][3] = jump[3][1] = 2;
        jump[1][9] = jump[9][1] = jump[3][7] = jump[7][3] = jump[8][2] = jump[2][8] = jump[4][6] = jump[6][4] = 5;
        jump[7][9] = jump[9][7] = 8;
        jump[1][7] = jump[7][1] = 4;
        jump[3][9] = jump[9][3] = 6;
        int res = 0;

        selected[1] = true;
        res += helper(selected, jump, 0, 1, 1, m, n) * 4;
        selected[1] = false;
        selected[2] = true;
        res += helper(selected, jump, 0, 2, 1, m, n) * 4;
        selected[2] = false;
        selected[5] = true;
        res += helper(selected, jump, 0, 5, 1, m, n);
        selected[5] = false;

        return res;
    }

    static public int helper (boolean [] selected, int [][] jump, int prevKey, int key, int curNumKey, int m, int n) {
        if (curNumKey == n) {
            return 1;
        } else {
            int res = (curNumKey >= m)?1:0;

            for (int i=1;i<=9;i++) {
                if (!selected[i] && !selected[jump[prevKey][key]]) {
                    selected[i] = true;
                    res += helper(selected, jump, key, i, curNumKey+1, m, n);
                    selected[i] = false;
                }
            }

            return res;
        }
    }

    public static void main(String [ ] args) {

        // 9
        System.out.println(numberOfPatterns(1,1));
        System.out.println(numberOfPatterns(4,9));

    }
}
