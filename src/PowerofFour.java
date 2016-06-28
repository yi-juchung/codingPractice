public class PowerofFour {
    static public boolean isPowerOfFour(int num) {
        if ((num & (num -1)) != 0) return false;
        if ((num & 0x55555555) != 0) return true;
        return false;
    }

    public static void main(String [ ] args) {
        System.out.println(isPowerOfFour(16));
        System.out.println(isPowerOfFour(5));
    }
}
