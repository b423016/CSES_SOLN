//package graph;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class sr2 {
    static class FastScanner {
        private InputStream stream;
        private byte[] buf = new byte[1 << 16];
        private int head, tail;

        public FastScanner() {
            this.stream = System.in;
        }

        private int read() {
            if (head >= tail) {
                head = 0;
                try {
                    tail = stream.read(buf, 0, buf.length);
                } catch (IOException e) {
                    return -1;
                }
                if (tail <= 0) return -1;
            }
            return buf[head++];
        }

        public int nextInt() {
            int c = read();
            while (c <= 32) {
                if (c == -1) return -1;
                c = read();
            }
            int res = 0;
            while (c > 32) {
                res = res * 10 + c - '0';
                c = read();
            }
            return res;
        }

        public long nextLong() {
            int c = read();
            while (c <= 32) {
                if (c == -1) return -1;
                c = read();
            }
            long res = 0;
            while (c > 32) {
                res = res * 10 + c - '0';
                c = read();
            }
            return res;
        }
    }

    static long inf = (long) 1e18;

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        if (n == -1) return;
        int m = sc.nextInt();
        int q = sc.nextInt();
        long[][] dist = new long[n+1][n+1];

        for(int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], inf);
            dist[i][i] = 0;
        }

        for(int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            long w = sc.nextLong();
            dist[u][v] = Math.min(dist[u][v], w);
            dist[v][u] = Math.min(dist[v][u], w);
        }

        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(dist[i][k] != inf && dist[k][j] != inf)
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < q; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            if(dist[u][v] == inf) {
                sb.append("-1\n");
            } else {
                sb.append(dist[u][v]).append("\n");
            }
        }
        System.out.print(sb);
    }
}
