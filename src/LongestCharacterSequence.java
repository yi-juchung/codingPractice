public class LongestCharacterSequence {

    public static String findLong(String s) {

        int curCount = 0;
        int maxCount = 0;
        Character cand = '-';
        int startIdx = -1;
        for(int i=0;i<s.length();i++) {
            Character c = s.charAt(i);
            if (cand != c) {
                cand = c;
                curCount = 1;
            } else {
                curCount++;
            }

            if (curCount > maxCount) {
                maxCount = curCount;
                startIdx = i-maxCount+1;
            }
        }

        return s.substring(startIdx,startIdx+maxCount);

    }

    public static void main(String [ ] args) {

        System.out.print(findLong("aaaaabbbcccccc"));
    }
}
