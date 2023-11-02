package leetcode;

public class LeetCode2525 {
    public String categorizeBox(int length, int width, int height, int mass) {
        boolean bk = false;
        boolean hv = mass >= 100;
        if (length >= 1e4 || width >= 1e4 || height >= 1e4 || (long) length * width * height >= 1e9) {
            bk = true;
        }
        if (bk && hv) {
            return "Both";
        }else if (bk){
            return "Bulky";
        }else if (hv){
            return "Heavy";
        }
        return "Neither";
    }
}
