package bisai;

/**
 * @author = wangyilin29
 * @date = 2024/4/7
 **/
public class JingSai100264 {
    public int longestMonotonicSubarray(int[] nums) {
        int result = 0;
        int currADD = 1;
        int currDEC = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                currADD++;
                result = Math.max(currADD, result);
            } else {
                result = Math.max(currADD, result);
                currADD = 1;
            }
            if (nums[i] < nums[i - 1]) {
                currDEC++;
                result = Math.max(currDEC, result);
            } else {
                result = Math.max(currDEC, result);
                currDEC = 1;
            }
        }
        return result;
    }
}
