package leetcode;

public class LeetCode2103 {
    public int countPoints(String rings) {
        int result = 0;
        int[] color = new int[10];
        int R = 1;
        int G = 1 << 1;
        int B = 1 << 2;
        if (rings.length() <= 6) {
            return result;
        }
        char[] charArray = rings.toCharArray();
        for (int i = 0; i < charArray.length; i += 2) {
            int c;
            switch (charArray[i]) {
                case 'R':
                    c = R;
                    break;
                case 'G':
                    c = G;
                    break;
                case 'B':
                    c = B;
                    break;
                default:
                    c = 0;
            }
            int index = charArray[i + 1] - '0';
            color[index] |= c;
        }
        for (int j : color) {
            if (j == 7) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String rings = "B0B6G0R6R0R6G9";
        LeetCode2103 leetCode2103 = new LeetCode2103();
        leetCode2103.countPoints(rings);
    }
}
