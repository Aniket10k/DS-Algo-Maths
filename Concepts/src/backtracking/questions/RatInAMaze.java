package backtracking.questions;
import java.util.*;
public class RatInAMaze {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

           
            ArrayList<String> res = Parse.findPath(a, n);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Parse {
    
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int[][] visited = new int[n][n];
        recPath(m, 0, 0, n, sb, visited, ans);
        Collections.sort(ans);
        //System.out.println(ans.toString());
        return ans;
    }
    
    static void recPath(int[][] a, int x, int y, int n, StringBuilder sb, int[][] visited, ArrayList<String> ans){
        if(a[0][0]==0) return;
        if(x==n-1 && y==n-1){
            ans.add(new String(sb));
        }
        visited[x][y]=1;
        int[] x1 = new int[]{1,0,0,-1};
        int[] y1 = new int[]{0,-1,1,0};
        for(int i=0;i<4;i++){
            int x_c = x+x1[i];
            int y_c = y+y1[i];
            if(x_c<0 || x_c >=n || y_c<0 || y_c>=n || a[x_c][y_c]==0 || visited[x_c][y_c]==1){
                continue;
            }
            if(x1[i]==1) sb.append('D');
            if(y1[i]==-1) sb.append('L');
            if(y1[i]==1) sb.append('R');
            if(x1[i]==-1) sb.append('U');
            recPath(a, x_c, y_c, n, sb, visited, ans);
            sb.deleteCharAt(sb.length()-1);
        }
        visited[x][y]=-1;
    }
}