import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TextJustificationWithPages {
    static public List<String> fullJustify(String word, int width) {
        List<String> res = new LinkedList<>();
        List<Integer> spaces = new ArrayList<>();
        List<Integer> marks = new ArrayList<>();

        int i=0;
        for (;i<word.length();i++) {
            if (word.charAt(i) == ' ') {
                spaces.add(i);
                if (i == 0) continue;

                switch (word.charAt(i-1)) {
                    case '!':case ',':case '.':case '?': marks.add(i);
                }
            }
        }
        spaces.add(i);
        marks.add(i);

        boolean done = false;
        int pageLen = 5;
        int digit = 1;
        while (!done) {
            int start = 0;
            int markIdx = 0;
            int spaceIdx = 0;

            done = true;
            while (done && markIdx < marks.size()) {
                if (marks.get(markIdx)-start <= width-pageLen) {
                    markIdx++;
                    continue;
                }

                if (markIdx > 0 && marks.get(markIdx-1) > start && marks.get(markIdx-1) - start <= width-pageLen) {
                    res.add(word.substring(start,marks.get(markIdx-1)));
                    start = marks.get(markIdx-1)+1;
                } else {
                    while (spaceIdx < spaces.size() && spaces.get(spaceIdx) - start <= width-pageLen ) {
                        spaceIdx++;
                    }

                    if (spaceIdx > 0 && spaces.get(spaceIdx) > start+width-pageLen) spaceIdx--;
                    if (spaces.get(spaceIdx) > start && spaces.get(spaceIdx) - start <= width-pageLen) {
                        res.add(word.substring(start, spaces.get(spaceIdx)));
                        start = spaces.get(spaceIdx)+1;
                    } else {
                        res.add(word.substring(start,start+width-pageLen));
                        start += start+width-pageLen;
                    }
                }

                if (Integer.toString(res.size()).length() > digit) {
                    res.clear();
                    digit++;
                    pageLen += 2;
                    done = false;
                    break;
                }
            }

            if (done) {
                res.add(word.substring(start,marks.get(markIdx-1)));
            }

            if (Integer.toString(res.size()).length() > digit) {
                res.clear();
                digit++;
                pageLen += 2;
                done = false;
            }
        }

        String page = "/"+res.size()+")";
        for (i=0;i<res.size();i++) {
            res.set(i, res.get(i)+"("+Integer.toString(i+1)+page);
        }

        return res;
    }

    public static void main(String [ ] args) {

        for (String s : fullJustify("Hi! Yi-Ju, your Uber is coming soon, thanks for waiting. Hi! Yi-Ju, your Uber is coming soon, thanks for waiting. Hi! Yi-Ju, your Uber is coming soon, thanks for waiting.",15)) {
            System.out.println(s);
            System.out.println(s.length());
        }
    }
}
