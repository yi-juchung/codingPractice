public class DungeonGame {
    static public int calculateMinimumHP(int[][] dungeon) {

        if (dungeon == null || dungeon.length < 1 || dungeon[0].length < 1) {
            return 0;
        }

        int m = dungeon[0].length;
        int n = dungeon.length;

        dungeon[n-1][m-1] = Math.max(1-dungeon[n-1][m-1], 1);
        for (int i=m-2;i>=0;i--) {
            dungeon[n-1][i] = Math.max(dungeon[n-1][i+1]-dungeon[n-1][i],1);
        }
        for (int i=n-2;i>=0;i--) {
            dungeon[i][m-1] = Math.max(dungeon[i+1][m-1]-dungeon[i][m-1],1);
        }

        for (int i=n-2;i>=0;i--) {
            for (int j=m-2;j>=0;j--) {
                dungeon[i][j] = Math.max(Math.min(dungeon[i+1][j],dungeon[i][j+1])-dungeon[i][j],1);
            }
        }

        return dungeon[0][0];
    }

    public static void main(String [ ] args) {

        int [][] dungeon = new int [][] {
                {-2,-3,3},
                {-5,-10,1},
                {10,30,-5}
        };

        System.out.println(calculateMinimumHP(dungeon));
    }
}
