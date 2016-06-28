public class ShortestWordDistance {

    public static class Dict {

        String [] words;

        public Dict(String [] ws) {
            words = ws;
        }


        public int dist(String word1, String word2) {
            int minDist = Integer.MAX_VALUE;

            String lastWord = null;
            int lastIdx = -1;

            for (int i=0;i<words.length;i++) {
                String s = words[i];
                if (s.equals(word1) || s.equals(word2)) {
                    if (lastWord != null && !s.equals(lastWord)) {
                        if (i-lastIdx < minDist) {
                            minDist = i-lastIdx;
                        }
                    }

                    lastIdx = i;
                    lastWord = s;
                }
            }

            return minDist;
        }
    }

    public static void main(String [ ] args) {
        String [] words = new String[] {
                "practice", "makes", "perfect", "coding", "makes"
        };

        Dict d = new Dict(words);

        System.out.println(d.dist("coding","practice"));
        System.out.println(d.dist("makes","coding"));

    }
}
