package leetcode;

public class LeetCode1614 {
    public int maxDepth(String s) {
        int ans=0,sum=0;
        for (char c:s.toCharArray()){
            if (c=='('){
                sum++;
                ans=Math.max(sum,ans);
            }else if (c==')'){
                sum--;
            }
        }
        return ans;
    }
}
