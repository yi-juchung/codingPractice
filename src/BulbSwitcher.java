public class BulbSwitcher {
    static public int bulbSwitch(int n) {
//        boolean [] swi = new boolean [n];
//
//        for (int i=0;i<n;i++) {
//            for (int j=i;j<n;j += (i+1)) {
//                swi[j] = !swi[j];
//            }
//        }
//
//        int count = 0;
//        for (boolean b:swi) {
//            if (b)
//                count++;
//        }
//
//        return count;


        return (int)Math.sqrt(n);
    }

    public static void main(String [ ] args) {
        System.out.println(bulbSwitch(10));
    }
}
