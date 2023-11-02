package mianshi;

public class MaYi {
    public boolean check1(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        char[] sc = s.toCharArray();
        char[] gc = goal.toCharArray();
        for (int i = 0; i < 2 * sc.length; i++) {
            boolean result = true;
            for (int j = 0; j < sc.length; j++) {
                if (gc[j] == sc[(i + j) % sc.length]) {
                    continue;
                }
                result = false;
                break;
            }
            if (result) {
                return true;
            }
        }
        return false;
    }

    public boolean check2(String s, String goal) {
        /*
            s+s后判断goal是否是s的字串即可
         */
        String origin = s + s;
        return origin.contains(goal);
    }

    public static void main(String[] args) {
        MaYi maYi = new MaYi();
        System.out.println(maYi.check1("abcd", "bcda"));
    }
}
