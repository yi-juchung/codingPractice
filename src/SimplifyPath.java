import java.util.Stack;

public class SimplifyPath {
    static public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        String [] paths = path.split("/");

        Stack<String> res = new Stack<String>();

        for(String p : paths) {
            if (p.equals(".")) {
                continue;
            } else if (p.equals("..")) {
                if (!res.isEmpty()) {
                    res.pop();
                }
            } else if (p.length() > 0) {
                res.push(p);
            }
        }

        if (res.isEmpty()) {
            sb.append("/");
        }

        while(!res.isEmpty()) {
            sb.insert(0,"/"+res.pop());
        }

        return sb.toString();
    }

    public static void main(String [ ] args) {
        System.out.print(simplifyPath("/a/./b/../../c/"));
    }
}
