package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode2442 {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> result = new HashSet<>();
        if (nums == null || nums.length == 0) {
            return 0;
        }
        for (int num : nums) {
            result.add(num);
            StringBuilder builder = new StringBuilder();
            while (num > 0) {
                builder.append(num % 10);
                num=num/10;
            }
            String str=builder.toString();
            int rev=Integer.parseInt(str);
            result.add(rev);
        }

        return result.size();
    }

    public static void main(String[] args) {
        LeetCode2442 leetCode2442=new LeetCode2442();
        leetCode2442.countDistinctIntegers(new int[]{1,10});
    }
}
