public class ContainerWithMostWater {
    static public int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;

        int curMax = 0;
        while(i<j) {
            int curArea = Math.min(height[i],height[j])*(j-i);
            if (curArea > curMax) {
                curMax = curArea;
            }

            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }

        return curMax;
    }

    public static void main(String [ ] args) {
        int [] val = new int []{1, 2, 13, 14, 5, 6};

        System.out.println(maxArea(val));
    }
}
