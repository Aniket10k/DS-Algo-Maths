package dp.questions;

public class MinimumOperations
{
    public int dpF(int[] dp, int n){
        if(dp[n]!=0){
            return dp[n];
        }
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(n%2==0)
            dp[n] = Math.min(dpF(dp, n-1) + 1, dpF(dp, n/2) + 1);
        else
            dp[n] = dpF(dp, n-1)+1;
        return dp[n];
    }
    public int minOperation(int n)
    {
        
        int[] dp = new int[n+1];
        return dpF(dp, n);
        
        
        /*
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<n+1;i++){
            if(i%2==0){
                dp[i] = Math.min(dp[i-1] + 1, dp[i/2] +1);
            }
            else{
                dp[i] = dp[i-1] + 1;
            }
        }
        
        return dp[n];
        */
    }
}
