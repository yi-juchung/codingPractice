public class ShortestWordDistanceIII {
    public static int shortestWordDistance(String[] words, String word1, String word2) {

        int curMinDis = Integer.MAX_VALUE;
        int prevIdx=-1;
        boolean sameWord = word1.equals(word2);

        for (int i=0;i<words.length;i++) {
            if (words[i].equals(word1) || words[i].equals(word2)) {
                if (prevIdx == -1) {
                    prevIdx = i;
                    continue;
                }

                if (prevIdx != -1 && (sameWord || !words[prevIdx].equals(words[i]))) {
                    if (i-prevIdx < curMinDis) {
                        curMinDis = i-prevIdx;
                    }

                    prevIdx = i;
                }
            }
        }


        return curMinDis;
    }

    public static void main(String [ ] args) {
        String [] input = new String [] {"practice", "makes", "perfect", "coding", "makes"};

        System.out.println(shortestWordDistance(input,"makes","coding"));
        System.out.println(shortestWordDistance(input,"makes","makes"));
    }
}
