//package graph;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class cycle {
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
            // CRITICAL FIX: Handle negative numbers
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

        // Added nextLong for the edge weights
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

    static class Edge {
        int u, v;
        long w; // CRITICAL FIX: Weight must be long to prevent overflow
        Edge(int u, int v, long w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        if (n == -1) return; // EOF protection
        int m = sc.nextInt();

        List<Edge> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            long w = sc.nextLong(); // Read as long
            list.add(new Edge(a, b, w));
        }

        // CRITICAL FIX: dist must be long
        long[] dist = new long[n + 1];
        int[] par = new int[n + 1];

        // Starting all distances at 0 perfectly handles disconnected components
        Arrays.fill(dist, 0);

        int x = -1;

        // Run Bellman-Ford N times
        for (int i = 1; i <= n; i++) {
            x = -1;
            for (Edge e : list) {
                if (dist[e.u] + e.w < dist[e.v]) {
                    dist[e.v] = dist[e.u] + e.w;
                    par[e.v] = e.u;
                    x = e.v; // x will be the last node relaxed in the N-th step
                }
            }
        }

        if (x == -1) {
            System.out.println("NO");
        } else {
            // Walk back N times to guarantee we fall into the cycle
            for (int i = 1; i <= n; i++) {
                x = par[x];
            }

            List<Integer> res = new ArrayList<>();
            int curr = x;

            // Reconstruct the cycle
            do {
                res.add(curr);
                curr = par[curr];
            } while (curr != x);
            res.add(x);

            // The path was traced backwards, so reverse it
            Collections.reverse(res);

            System.out.println("YES");
            StringBuilder sb = new StringBuilder();
            for (int node : res) {
                sb.append(node).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}