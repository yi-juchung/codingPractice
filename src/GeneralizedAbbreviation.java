import java.util.LinkedList;
import java.util.List;

public class GeneralizedAbbreviation {
    static public List<String> generateAbbreviations(String word) {
        char [] chars = word.toCharArray();
        List<String> res = new LinkedList<>();

        bc(chars, 0, 0, res, new StringBuilder());

        return res;
    }

    static public void bc(char [] chars, int curIdx, int num,List<String> res, StringBuilder sb) {
        int oriLen = sb.length();

        if (curIdx == chars.length) {
            if (num != 0) {
                sb.append(num);
            }

            res.add(sb.toString());
        } else {
            bc(chars, curIdx+1, num+1, res, sb);

            if (num != 0) {
                sb.append(num);
            }

            bc(chars, curIdx+1, 0, res, sb.append(chars[curIdx]));
        }

        sb.setLength(oriLen);
    }

    public static void main(String [ ] args) {
        for (String s : generateAbbreviations("word")) {
            System.out.println(s);
        }
    }
}
