public class AddDigits {
    static public int addDigits(int num) {
        return (num==0)?0:(num-1)%9+1;
    }

//    static public int addDigits(int num) {
//        while (num/10 != 0) {
//            int res = 0;
//
//            while(num != 0) {
//                res += num%10;
//                num /= 10;
//            }
//
//            num = res;
//        }
//
//        return num;
//    }

    public static void main(String [ ] args) {

        // 2
        System.out.print(addDigits(38));
    }
}
