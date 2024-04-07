package bisai;

/**
 * @author = wangyilin29
 * @date = 2024/4/7
 **/
public class JingSai100242 {
    public static void main(String[] args) {
        int lenA = 'a' + 26 - 'z';
        System.out.println((char) ('a' + 1));
    }

    public String getSmallestString(String s, int k) {
        if (k == 0) {
            return s;
        }
        char[] charArray = s.toCharArray();
        StringBuilder result = new StringBuilder();
        int len = 0;
        for (char c : charArray) {
            int lenA = Math.min('a' + 26 - c, c - 'a');
            if (len + lenA <= k) {
                result.append('a');
                len += lenA;
            } else if (len < k) {
                int lenPre = k - len;
                result.append((char) (c - lenPre));
                len += lenPre;
            } else {
                result.append(c);
            }

        }

        return result.toString();
    }
}
