
public class BullsandCows {
    static public String getHint(String secret, String guess) {
        int a = 0;
        int b = 0;

        int [] numsSec = new int[10];
        int [] numsGus = new int[10];
        for (int i=0;i<secret.length();i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                a++;
            } else {
                numsSec[secret.charAt(i)-'0']++;
                numsGus[guess.charAt(i)-'0']++;
            }
        }

        for (int i=0;i<10;i++) {
            if (numsSec[i] > 0 && numsGus[i] > 0) {
                b += Math.min(numsSec[i],numsGus[i]);
            }
        }

        return a+"A"+b+"B";
    }

    public static void main(String [ ] args) {

        // 1A3B
        System.out.println(getHint("1807","7810"));

        // 1A1B
        System.out.println(getHint("1123","0111"));

        // 1A2B
        System.out.println(getHint("011","110"));
    }
}
