import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    static public List<String> fullJustify(String[] words, int width) {
        List<String> res = new ArrayList<String>();
        if (words == null || words.length == 0)
            return res;
        int count = 0;
        int last = 0;
        for(int i=0;i<words.length;i++) {
            if(count+words[i].length()+(i-last) > width) {
                int spaceNum = 0;
                int extraNum = 0;
                if(i-last-1>0) {
                    spaceNum = (width-count)/(i-last-1);
                    extraNum = (width-count)%(i-last-1);
                }

                StringBuilder str = new StringBuilder();
                for(int j=last;j<i;j++) {
                    str.append(words[j]);
                    if(j<i-1) {
                        for(int k=0;k<spaceNum;k++) {
                            str.append(" ");
                        }

                        if(extraNum>0) {
                            str.append(" ");
                        }
                        extraNum--;
                    }
                }

                for(int j=str.length();j<width;j++) {
                    str.append(" ");
                }
                res.add(str.toString());
                count=0;
                last=i;
            }
            count += words[i].length();
        }
        StringBuilder str = new StringBuilder();
        for(int i=last;i<words.length;i++)
        {
            str.append(words[i]);
            if(str.length()<width)
                str.append(" ");
        }
        for(int i=str.length();i<width;i++)
        {
            str.append(" ");
        }
        res.add(str.toString());
        return res;
    }

//    static public List<String> fullJustify(String[] words, int maxWidth) {
//        List<String> res = new LinkedList<String>();
//
//        int space = 0;
//        int curLen = 0;
//
//        for (int i=0;i<words.length;i++)  {
//            int j=i;
//            for (;j<words.length;j++) {
//                if (curLen+space+words[j].length()+1 > maxWidth) {
//                    space = maxWidth-curLen;
//                    j--;
//                    break;
//                } else {
//                    space++;
//                    curLen += words[j].length();
//                }
//            }
//
//            if (j == words.length) {
//
//                if (curLen != 0) {
//                    res.add(composeString(words, i, j-1, maxWidth-curLen));
//                }
//
//                break;
//            }
//
//
//            res.add(composeString(words, i, j, space));
//            space = 0;
//            curLen = 0;
//            i=j;
//        }
//
//        return res;
//    }
//
//    static public String composeString(String[] words, int i, int j, int totalSpaces) {
//        StringBuilder sb = new StringBuilder();
//
//        int num = j-i;
//        double perSpace = (num == 0)?0:Math.ceil(totalSpaces/num);
//        for (int cur=i;cur<=j;cur++) {
//            sb.append(words[cur]);
//            perSpace = Math.min(perSpace,totalSpaces);
//            for(int sp=0;sp<perSpace;sp++) {
//                sb.append(" ");
//            }
//            totalSpaces -= perSpace;
//        }
//
//        return sb.toString();
//    }

    public static void main(String [ ] args) {
        String [] input = new String[] {
                "This", "is", "an", "example", "of", "text", "justification."
        };

//        String [] input = new String[] {
//                "a","b","c","d","e"
//        };

        for (String s : fullJustify(input,10)) {
            System.out.println(s);
        }
    }
}
