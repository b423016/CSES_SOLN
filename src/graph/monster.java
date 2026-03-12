//package graph;
import java.io.*;
import java.util.*;

public class monster {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
    }

    static int n, m;
    static char[][] grid;
    static int[][] mons, dist;
    static int[][] pr, pc;
    static char[][] move;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static char[] dc = {'D', 'U', 'R', 'L'};

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        m = sc.nextInt();

        grid = new char[n][m];
        mons = new int[n][m];
        dist = new int[n][m];
        pr = new int[n][m];
        pc = new int[n][m];
        move = new char[n][m];

        int sx = -1, sy = -1;
        Queue<int[]> monsterQueue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                grid[i][j] = s.charAt(j);
                mons[i][j] = Integer.MAX_VALUE;
                dist[i][j] = Integer.MAX_VALUE;

                if (grid[i][j] == 'M') {
                    monsterQueue.add(new int[]{i, j});
                    mons[i][j] = 0;
                }
                if (grid[i][j] == 'A') {
                    sx = i;
                    sy = j;
                }
            }
        }

        bfsm(monsterQueue);
        String path = bfsp(sx, sy);

        if (path == null) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
            System.out.println(path.length());
            System.out.println(path);
        }
    }

    public static void bfsm(Queue<int[]> q) {
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || grid[nx][ny] == '#') continue;

                if (mons[nx][ny] > mons[x][y] + 1) {
                    mons[nx][ny] = mons[x][y] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    public static String bfsp(int sx, int sy) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx, sy});
        dist[sx][sy] = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            if (x == 0 || y == 0 || x == n - 1 || y == m - 1) {
                return build(x, y, sx, sy);
            }

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || grid[nx][ny] == '#') continue;

                int nt = dist[x][y] + 1;
                if (nt < mons[nx][ny] && dist[nx][ny] == Integer.MAX_VALUE) {
                    dist[nx][ny] = nt;
                    pr[nx][ny] = x;
                    pc[nx][ny] = y;
                    move[nx][ny] = dc[k];

                    q.add(new int[]{nx, ny});
                }
            }
        }
        return null;
    }

    public static String build(int ex, int ey, int sx, int sy) {
        StringBuilder sb = new StringBuilder();
        int cx = ex;
        int cy = ey;

        while (cx != sx || cy != sy) {
            sb.append(move[cx][cy]);
            int prevX = pr[cx][cy];
            int prevY = pc[cx][cy];
            cx = prevX;
            cy = prevY;
        }

        return sb.reverse().toString();
    }
}