import java.util.LinkedList;
import java.util.List;

public class RestoreIPAddresses {
    static public List<String> restoreIpAddresses(String s) {
        List<String> res = new LinkedList<String>();

        if(s==null || s.length()==0)
            return res;

        helper(s,0,1,"",res);
        return res;
    }

    static public void helper(String s, int index, int segment, String item, List<String> res) {
        if(index >= s.length())
            return;
        if(segment == 4)
        {
            String str = s.substring(index);
            if(isValid(str))
                res.add(item+"."+str);
            return;
        }
        for(int i=1;i<4&&(i+index<=s.length());i++)
        {
            String str = s.substring(index, index+i);
            if(isValid(str))
            {
                if(segment==1)
                    helper(s,index+i,segment+1,str,res);
                else
                    helper(s,index+i,segment+1,item+"."+str,res);
            }
        }
    }

    static public boolean isValid(String sub) {
        if(sub==null || sub.length()>3)
            return false;
        int num = Integer.parseInt(sub);
        if(sub.charAt(0)=='0' && sub.length()>1)
            return false;
        if(num>=0 && num<=255)
            return true;
        return false;
    }

    public static void main(String [ ] args) {
        String s = "0000";

        List<String> ss = restoreIpAddresses(s);

        for (String string : ss) {
            System.out.println(string);
        }
    }
}
