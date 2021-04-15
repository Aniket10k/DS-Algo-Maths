package graph.questions;

public class WhetherPathExists {
    // M : input matrix
    // N : size of the matrix
    public static int is_possible(int adj[][], int n) {
        int[][] visited=  new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(adj[i][j]==1){
                    boolean b = dfs(i, j, adj, visited, n);
                    if(b) return 1;
                }
            }
        }
        return 0;
    }
    static boolean dfs(int i, int j, int[][] adj, int[][] visited, int n){
        int[] x1 = new int[]{1, 0 , -1, 0};
        int[] y1 = new int[]{0, 1, 0, -1};
        
        if(adj[i][j]==2) return true;
        visited[i][j] = 1;
        for(int t=0;t<4;t++){
            int x = i + x1[t];
            int y = j + y1[t];
            if(x<0 || x>=n || y<0 || y>=n || visited[x][y]==1 || adj[x][y]==0){
                continue;
            }
            boolean b = dfs(x, y, adj, visited, n);
            if(b) return b;
        }
        return false;
        
    }
}