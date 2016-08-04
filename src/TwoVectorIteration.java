public class TwoVectorIteration {

    static class Iter {
        int [][] data;
        int i = -1;
        int j = -1;
        boolean removable = false;
        int ri;
        int rj;

        public Iter (int [][] d) {
            data = d;
        }

        public Integer next () throws Exception {
            if (hasNext()) {
                removable = true;
                ri = i;
                rj = j;
                return data[i][j++];
            } else {
                throw new Exception("out of range");
            }
        }

        public boolean hasNext () {
            if (i < data.length) {
                if (i != -1) {
                    if (j >= 0 && j < data[i].length) {
                        return true;
                    } else if (j == -1) {
                        j = 0;
                        return hasNext();
                    } else {
                        nextLevel();
                        return hasNext();
                    }
                } else {
                    nextLevel();
                    return hasNext();
                }
            } else {
                return false;
            }
        }

        private void nextLevel() {
            i++;
            j=0;
        }

        public void remove () throws Exception {
            if (removable) {
                int [] replaced = new int [data[ri].length-1];

                for (int k=0, l=0;k<data[ri].length;k++,l++) {
                    if (k == rj) {
                        l--;
                        continue;
                    }

                    replaced[l] = data[ri][k];
                }

                data[ri] = replaced;
                j--;
                removable = false;
            } else {
                throw new Exception("nothing to remove");
            }
        }
    }

    public static void main(String [ ] args) {

        int [][] data = {
                {1,2},
                {},
                {3},
                {5,6}
        };

//        try {
//            Iter i = new Iter(data);
//
//            System.out.println(i.hasNext());
//            System.out.println(i.next());
//            System.out.println(i.next());
//            System.out.println(i.next());
//            System.out.println(i.next());
//            System.out.println(i.next());
//            System.out.println(i.next());
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

        try {
            Iter i = new Iter(data);

            System.out.println(i.hasNext());
            //i.remove();
            System.out.println(i.next());
            i.remove();
            System.out.println(i.next());
            System.out.println(i.next());
            System.out.println(i.next());
            System.out.println(i.next());
            System.out.println(i.next());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        for (int [] i : data) {
            for (int j : i) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
