public class WallsandGates {
    static public void wallsAndGates(int[][] rooms) {
        for (int i=0;i<rooms.length;i++) {
            for (int j=0;j<rooms[0].length;j++) {
                if (rooms[i][j] == 0) {
                    expand(rooms,i,j,0);
                }
            }
        }
    }

    static public void expand(int [][] rooms, int i, int j, int step) {
        if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] == -1) {
            return;
        }

        if (rooms[i][j] >= step) {
            rooms[i][j] = step;

            expand(rooms,i+1,j,step+1);
            expand(rooms,i,j+1,step+1);
            expand(rooms,i-1,j,step+1);
            expand(rooms,i,j-1,step+1);
        }
    }

    public static void main(String [ ] args) {

        int [][] rooms = new int [][] {
                {Integer.MAX_VALUE, -1, 0,Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE,-1},
                {Integer.MAX_VALUE, -1, Integer.MAX_VALUE,-1},
                {0, -1, Integer.MAX_VALUE,Integer.MAX_VALUE}
        };

        wallsAndGates(rooms);

        for (int i=0;i<rooms.length;i++) {
            for (int j=0;j<rooms[0].length;j++) {
                System.out.println(rooms[i][j]);
            }
        }
    }
}
