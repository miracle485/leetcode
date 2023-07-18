package leetcode;

public class LeetCode415 {
    public String addStrings(String num1, String num2) {
        StringBuilder rev = new StringBuilder();
        int n1 = num1.length() - 1, n2 = num2.length() - 1;
        char[] c1 = num1.toCharArray(), c2 = num2.toCharArray();
        int pre = 0;
        while (n1 >= 0 || n2 >= 0) {
            int s1 = 0;
            int s2 = 0;
            if (n1 >= 0) {
                s1 = c1[n1] - 48;
                n1--;
            }
            if (n2 >= 0) {
                s2 = c2[n2] - 48;
                n2--;
            }
            int s = s1 + s2 + pre;
            rev.append(s % 10);
            pre = s / 10;

        }
        if (pre != 0) {
            rev.append(pre);
        }

        return rev.reverse().toString();
    }

    public static void main(String[] args) {
        String n1 = "11";
        String n2 = "123";
        LeetCode415 leetCode415 = new LeetCode415();
        System.out.println(leetCode415.addStrings(n1, n2));
    }
}
