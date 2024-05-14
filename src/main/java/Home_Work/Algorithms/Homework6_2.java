package Home_Work.Algorithms;


public class Homework6_2 {
    public int longestMonotonicSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxLength = 1;
        int currentLength = 1;
        boolean increasing = false;
        boolean decreasing = false;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                if (decreasing) {
                    currentLength = 1;
                }
                currentLength++;
                increasing = true;
                decreasing = false;
            } else if (nums[i] < nums[i - 1]) {
                if (increasing) {
                    currentLength = 1;
                }
                currentLength++;
                decreasing = true;
                increasing = false;
            } else {
                currentLength = 1;
                increasing = false;
                decreasing = false;
            }
            maxLength = Math.max(maxLength, currentLength);
        }
        return maxLength;
    }
}
