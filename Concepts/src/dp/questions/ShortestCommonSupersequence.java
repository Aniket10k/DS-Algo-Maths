package dp.questions;

public class ShortestCommonSupersequence {
	public static int shortestCommonSupersequence(String X, String Y, int m, int n)
	{
	    
	    char[] x = X.toCharArray();
	    char[] y = Y.toCharArray();
	    
	    int[][] dp = new int[m+1][n+1];
	    
	    for(int i=0;i<m+1;i++){
	        dp[i][0] = i;
	    }
	    for(int j=0;j<n+1;j++){
	        dp[0][j] = j;
	    }
	    
	    dp[0][0] = 0;
	    
	    for(int i=1;i<m+1;i++){
	        for(int j=1;j<n+1;j++){
	            if(x[i-1]==y[j-1]){
	              dp[i][j] = dp[i-1][j-1] + 1;  
	            } else{
	                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
	            }
	        }
	    }
	    return dp[m][n];
	    
	}
}
