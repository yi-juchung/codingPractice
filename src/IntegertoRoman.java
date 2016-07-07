public class IntegertoRoman {
    static public String intToRoman(int num) {
        String [] symbol = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int [] val = {1000,900,500,400,100,90,50,40,10,9,5,4,1};

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<13; i++) {
            if (num >= val[i]) {
                int count = num/val[i];
                num %= val[i];
                for (int j=0;j<count;j++) {
                    sb.append(symbol[i]);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String [ ] args) {

        System.out.println(intToRoman(7));
    }
}
