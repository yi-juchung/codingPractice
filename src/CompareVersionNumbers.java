public class CompareVersionNumbers {
    static public int compareVersion(String version1, String version2) {
        String [] first = version1.split("\\.");
        String [] second = version2.split("\\.");

        if (Integer.parseInt(first[0]) < Integer.parseInt(second[0])) {
            return -1;
        } else if (Integer.parseInt(first[0]) == Integer.parseInt(second[0])) {
            if (first.length > 1 && second.length > 1) {
                return compareVersion(version1.substring(version1.indexOf('.')+1), version2.substring(version2.indexOf('.')+1));
            } else if (first.length > 1) {
                return (Integer.parseInt(first[1]) == 0)?0:1;
            } else if (second.length > 1) {
                return (Integer.parseInt(second[1]) == 0)?0:-1;
            } else {
                return 0;
            }
        } else {
            return 1;
        }
    }

    public static void main(String [ ] args) {
        System.out.println(compareVersion("1.0", "1"));
    }
}
