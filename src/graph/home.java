//package graph;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class home {
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
            boolean negative = false;
            if (c == '-') {
                negative = true;
                c = read();
            }
            int res = 0;
            while (c > 32) {
                res = res * 10 + c - '0';
                c = read();
            }
            return negative ? -res : res;
        }

        public long nextLong() {
            int c = read();
            while (c <= 32) {
                if (c == -1) return -1;
                c = read();
            }
            boolean negative = false;
            if (c == '-') {
                negative = true;
                c = read();
            }
            long res = 0;
            while (c > 32) {
                res = res * 10 + c - '0';
                c = read();
            }
            return negative ? -res : res;
        }
    }

    // Use 1e17 to prevent underflow when subtracting large weights
    static long inf = (long) 1e17;
    static long n_inf = (long) -1e17;

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        if (n == -1) return;
        int m = sc.nextInt();

        long[] dist = new long[n + 1];
        Arrays.fill(dist, inf);
        dist[1] = 0;

        long[][] edges = new long[m][3];
        for (int i = 0; i < m; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = -sc.nextLong();
        }
        for (int i = 1; i < n; i++) {
            for (long[] e : edges) {
                int u = (int) e[0];
                int v = (int) e[1];
                long weight = e[2];
                if (dist[u] != inf && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (long[] e : edges) {
                int u = (int) e[0];
                int v = (int) e[1];
                long weight = e[2];
                if (dist[u] != inf && dist[u] + weight < dist[v]) {
                    dist[v] = n_inf;
                }
            }
        }
        if (dist[n] == n_inf) {
            System.out.println("-1");
        } else {
            System.out.println(-dist[n]);
        }
    }
}