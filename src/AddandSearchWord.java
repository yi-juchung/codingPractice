public class AddandSearchWord {
    static class Dic {
        Dic [] dics = new Dic[26];
        boolean word = false;
    }

    static Dic root = new Dic();

    // Adds a word into the data structure.
    static public void addWord(String word) {
        Dic cur = root;

        for (int i=0;i<word.length();i++) {
            if (cur.dics[word.charAt(i)-'a'] == null) {
                cur.dics[word.charAt(i)-'a'] = new Dic();
            }

            cur = cur.dics[word.charAt(i)-'a'];
        }

        cur.word = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    static public boolean search(String word) {
        Dic cur = root;

        return helper(word, cur);
    }

    static private boolean helper(String word, Dic cur) {
        if (word.length() < 1) {
            return false;
        }

        char c = word.charAt(0);

        if (c == '.') {
            for (int i=0;i<26;i++) {
                if (cur.dics[i] != null) {
                    if (word.length() == 1 && cur.dics[i].word || helper(word.substring(1), cur.dics[i])) {
                        return true;
                    }
                }
            }

            return false;
        } else {
            if (cur.dics[c-'a'] == null) {
                return false;
            } else {
                if (word.length() == 1) {
                    return cur.dics[c-'a'].word;
                } else {
                    return helper(word.substring(1), cur.dics[c-'a']);
                }
            }
        }
    }

    public static void main(String [ ] args) {

        addWord("ran");addWord("rune");addWord("runner");addWord("runs");addWord("add");addWord("adds");addWord("adder");addWord("addee");

        System.out.println(search("r.n"));
        System.out.println(search("ru.n.e"));
        System.out.println(search("add"));
        System.out.println(search("add."));
        System.out.println(search("adde."));
        System.out.println(search(".an."));
        System.out.println(search("...s"));
        System.out.println(search("....e."));
        System.out.println(search("......."));
        System.out.println(search("..n.r"));

    }
}
