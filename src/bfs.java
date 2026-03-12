import java.util.*;
public class bfs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =  sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i< n ; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0 ; i < m; i++){
            int u =   sc.nextInt();
            int v =  sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        q.add(0);
        vis[0] = true;
        while(!q.isEmpty()){
            int curr = q.poll();
            System.out.print(curr + " ");
            for(int neighbor : graph.get(curr)){
                if(!vis[neighbor]){
                    vis[neighbor] = true;
                    q.add(neighbor);
                }
            }

        }
        sc.close();
    }
    public static void matrixbfs(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        vis[0][0] = true;
        int[] dirxx = { -1,0,1,0};
        int[] diry = {0,1,0,-1};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            System.out.print("("+ x + "," + y +") ");
            for(int i = 0 ; i<4 ; i++){
                int nx = x + dirxx[i];
                int ny = y + diry[i];
                if(nx >=0 && nx < n && ny >=0 && ny < m && !vis[nx][ny] && grid[nx][ny] == 1){
                    vis[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }

    }
}
