package graph;
import java.util.*;

public class labyrinth {
    static int[] dirx = {1, -1, 0, 0};
    static int[] diry = {0, 0, -1, 1};
    static char[] dirn = {'D', 'U', 'L', 'R'};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        char[][] maze = new char[n][m];
        for (int i = 0; i < n; i++) {
            maze[i] = sc.next().toCharArray();
        }

        bfs(maze, n, m);
        sc.close();
    }

    public static void bfs(char[][] maze, int n, int m) {
        Queue<int[]> q = new ArrayDeque<int[]>();
        boolean[][] vis = new boolean[n][m];
        int[][] pr = new int[n][m];
        int[][] pc = new int[n][m];
        char[][] move = new char[n][m];

        int sr = -1; int sc = -1;
        int er = -1; int ec = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maze[i][j] == 'A') {
                    sr = i; sc = j;
                } else if (maze[i][j] == 'B') {
                    er = i; ec = j;
                }
            }
        }

        q.add(new int[]{sr, sc});
        vis[sr][sc] = true;
        boolean reach = false;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int cur = curr[0];
            int cuc = curr[1];

            if (cur == er && cuc == ec) {
                reach = true;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int newr = cur + dirx[i];
                int newc = cuc + diry[i];
                if (newr < n && newc < m && newr >= 0 && newc >= 0 && !vis[newr][newc] && maze[newr][newc] != '#') {
                    vis[newr][newc] = true;
                    pr[newr][newc] = curr[0];
                    pc[newr][newc] = curr[1];
                    move[newr][newc] = dirn[i];
                    q.add(new int[]{newr, newc});
                }
            }
        }

        if (!reach) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
            StringBuilder sb = new StringBuilder();
            int currx = er;
            int curry = ec;

            while (currx != sr || curry != sc) {
                sb.append(move[currx][curry]);
                int prer = pr[currx][curry];
                int prec = pc[currx][curry];
                currx = prer;
                curry = prec;
            }

            sb.reverse();
            System.out.println(sb.length());
            System.out.println(sb.toString());
        }
    }
}