public class VerifyPreorderSerializationofaBinaryTree {
    static public boolean isValidSerialization(String preorder) {
        String [] nodes = preorder.split(",");
        int degree = 1;

        for (String s : nodes) {
            degree--;
            if (degree < 0) {
                return false;
            }

            if (!s.equals("#")) {
                degree += 2;
            }
        }

        return degree == 0;
    }

    public static void main(String [ ] args) {
        // true
        System.out.println(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));

        // false
        System.out.println(isValidSerialization("1,#"));

        // false
        System.out.println(isValidSerialization("9,#,#,1"));

        // false
        System.out.println(isValidSerialization("#,#,3,5,#"));

        // false
        System.out.println(isValidSerialization("7,2,#,2,#,#,#,6,#"));
    }
}
