import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsPhoneNumber {
    static String [] code = {"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    static public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<String>();
        generator(digits, 0, new StringBuilder(), res);

        return res;
    }

    static public void generator(String digit, int curIdx, StringBuilder sb, List<String> res) {
        if (curIdx < digit.length()) {
            int codeIdx = digit.charAt(curIdx)-49;
            for (char c : code[codeIdx].toCharArray()) {
                sb.append(c);
                generator(digit,curIdx+1,sb,res);
                sb.deleteCharAt(sb.length()-1);
            }
        } else {
            res.add(sb.toString());
        }
    }

    public static void main(String [ ] args) {

        String digits = "23";
        for (String list : letterCombinations(digits)) {
            System.out.println(list);
        }
    }
}
