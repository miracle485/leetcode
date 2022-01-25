package leetcode;

public class LeetCode400 {
    public static int findNthDigit(int n) {
        long now = 0;
        long num = 1;
        long preNum = 0;
        if (n <= 9) {
            return n;
        }
        while (now < n) {
            long cc = 1;
            long pre = 0;
            for (int i = 0; i < num; i++) {
                pre = cc;
                cc = cc * 10;
            }
            preNum = now;
            now = now + (cc - pre) * num;

            num++;
        }
        num=num-1;
        long cc = 1;
        long pre = 0;
        for (int i = 0; i < num; i++) {
            pre = cc;
            cc = cc * 10;
        }
        if (now == n) {

            return (int) cc - 1;
        }

        int cg = (int) (n - preNum);
        int index = (int) Math.ceil((1.0*cg )/ (num));
        int numIndex = (int) (cg-(index-1)*(num));
        int result= (int) (index+pre-1);
        int cnum= (int) (num-numIndex);
        while (cnum>0){
            result=result/10;
            cnum--;
        }
        return result%10;
    }

    public static void main(String[] args) {
        System.out.println(LeetCode400.findNthDigit(11));
    }
}
