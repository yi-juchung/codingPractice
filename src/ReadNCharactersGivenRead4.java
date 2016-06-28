public class ReadNCharactersGivenRead4 {

    /* int read4(char[] buf); */

    public int read(char[] buf, int n) {
        int readNum = 0;
        boolean eof = false;
        char [] buf4 = new char[4];

        while (readNum < n && !eof) {
            int curRead = read4(buf4);

            if (curRead < 4) {
                eof = true;
            }

            System.arraycopy(buf4, 0, buf, readNum, (readNum+curRead > n)?n-readNum:curRead);
            readNum += curRead;
        }

        return readNum;
    }

    // just mock
    public int read4(char[] nuf) {
        return 0;
    }
}
