package leetcode;

public class LeetCode537 {
    public String complexNumberMultiply(String num1, String num2) {
        String[] nums1=num1.split("\\+");
        String[] nums2=num2.split("\\+");
        int a1=Integer.parseInt(nums1[0]);
        int b1=Integer.parseInt(nums2[0]);
        int a2;
        int b2;
        if (nums1.length==1){
            a2=0;
            b2=0;
        }else {
            a2=Integer.parseInt(nums1[1].split("i")[0]);
            b2=Integer.parseInt(nums2[1].split("i")[0]);
        }

        int result1=0,result2=0;
        StringBuilder result=new StringBuilder();
        result1=a1*b1-a2*b2;
        result2=a1*b2+a2*b1;
        result.append(result1);
        if (result2>0){
            result.append("+");
        }
        result.append(result2);
        result.append("i");
        return result.toString();
    }

    public static void main(String[] args) {
        LeetCode537 leetCode537=new LeetCode537();
        System.out.println(leetCode537.complexNumberMultiply("1+1i","1+1i"));
    }
}
