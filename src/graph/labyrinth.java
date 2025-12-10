package graph;

import java.util.*;
public class labyrinth {
    private static final int[] dirx = {-1, 0, 1, 0};
    private static final int[] diry = {0, 1, 0, -1};
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] grid = new char[n][m];
        for(int i = 0; i<n ; i++) {
            grid[i] = sc.nextLine().toCharArray();
        }
        int room = 0 ;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == '.' && !visited[i][j]) {
                    bfs(n,m, i,j, grid, visited);
                    room++;
                }
            }
        }
    }

    public static void bfs(int n, int m, int src, int dest, char[][] grid,boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[n][m];
        if(grid[src][dest] == 1){
            q.add(new int[]{src, dest});
            visited[src][dest] = true;
        }
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            for(int i = 0; i<4 ; i++){
                int nx = x + dirx[i];
                int ny = y + diry[i];
                if(nx >=0 && nx < n && ny >=0 && ny < m && !visited[nx][ny] && grid[nx][ny] == 1){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }

    }
}
