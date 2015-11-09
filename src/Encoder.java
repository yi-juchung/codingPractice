public class Encoder {

    public static String encoder(String s) {
        StringBuilder sb = new StringBuilder();

        char [] chars = s.toCharArray();

        char cand = chars[0];
        int count = 1;
        for (int i=1;i<chars.length;i++) {
            if (cand == chars[i]) {
                count++;
            } else {
                if (count > 3) {
                    sb.append(count+"x"+cand);
                } else {

                    if (Character.isDigit(cand) && count == 1 && chars[i] == 'x') {
                        sb.append("1x"+cand);
                    } else {
                        for (int j=0;j<count;j++) {
                            sb.append(cand);
                        }
                    }
                }

                count = 1;
            }

            cand = chars[i];
        }

        if (count > 3) {
            sb.append(count+"x"+cand);
        } else {
            for (int j=0;j<count;j++) {
                sb.append(cand);
            }
        }

        return sb.toString();
    }

    public static void main(String [ ] args) {
        System.out.print(encoder("xxqqq1x3333"));
    }
}
