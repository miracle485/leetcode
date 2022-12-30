package leetcode;

public class LeetCode1799 {
    public int maxScore(int[] nums) {
        int ans = 0;

        return 1;
    }

    static class Pair {
        int x;
        int y;

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Pair pair = (Pair) obj;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {

            return x & y;
        }
    }

}
