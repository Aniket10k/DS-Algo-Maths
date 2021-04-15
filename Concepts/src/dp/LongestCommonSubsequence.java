package dp;

public class LongestCommonSubsequence {
    static int lcs(int p, int q, String s1, String s2){
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int[][] dp = new int[p][q];
        for(int i=0;i<p;i++){
            for(int j=0;j<q;j++){
                if(c1[i]==c2[j]){
                    if(i==0 || j==0){
                        dp[i][j] = 1;
                    } 
                    else{
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }
                } else{
                    if(i==0 && j==0){
                        dp[i][j] = 0;
                    } else if(i==0){
                        dp[i][j] = dp[i][j-1];
                    } else if(j==0){
                        dp[i][j] = dp[i-1][j];
                    } else{
                        dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]); 
                    }
                }
            }
        }
        return dp[p-1][q-1];
    }
    
}