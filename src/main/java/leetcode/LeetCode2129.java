package leetcode;

/**
 * @author = wangyilin29
 * @date = 2024/3/11
 **/
public class LeetCode2129 {
    public String capitalizeTitle(String title) {
        String[] list = title.split(" ");
        StringBuilder result = new StringBuilder();
        for (String s : list) {
            char[] a = s.toCharArray();
            if (a.length <= 2) {
                convertLess(a);
            } else {
                convertMore(a);
            }

            result.append(a).append(" ");
        }
        return result.toString().trim();
    }

    public void convertMore(char[] a) {
        if (a[0] >= 'a') {
            a[0] = (char) (a[0] - 32);
        }
        for (int i = 1; i < a.length; i++) {
            if (a[i] < 'a') {
                a[i] = (char) (a[i] + 32);
            }
        }
    }

    public void convertLess(char[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 'a') {
                a[i] = (char) (a[i] + 32);
            }
        }
    }
}
