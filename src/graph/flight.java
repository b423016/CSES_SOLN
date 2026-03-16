package graph;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.PriorityQueue;

public class flight {

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
    }

    // A lightweight object is much faster than an array!
    static class State implements Comparable<State> {
        long cost;
        int node;
        int used;

        public State(long cost, int node, int used) {
            this.cost = cost;
            this.node = node;
            this.used = used;
        }

        // Native comparison avoids Lambda overhead
        @Override
        public int compareTo(State o) {
            return Long.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        if (n == -1) return;
        int m = sc.nextInt();

        // --- FORWARD STAR GRAPH REPRESENTATION ---
        // This completely eliminates ArrayLists and Integer objects.
        int[] head = new int[n + 1];
        Arrays.fill(head, -1);
        int[] to = new int[m];
        int[] weight = new int[m];
        int[] nxt = new int[m];

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            to[i] = v;
            weight[i] = w;
            nxt[i] = head[u]; // Point to the previous edge from 'u'
            head[u] = i;      // Make 'i' the new first edge from 'u'
        }
        long[][] dist = new long[n + 1][2];
        for (int i = 0; i <= n; i++) {
            dist[i][0] = Long.MAX_VALUE;
            dist[i][1] = Long.MAX_VALUE;
        }

        PriorityQueue<State> pq = new PriorityQueue<>();
        dist[1][0] = 0;
        pq.add(new State(0, 1, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            if (cur.cost > dist[cur.node][cur.used]) {
                continue;
            }
            for (int e = head[cur.node]; e != -1; e = nxt[e]) {
                int v = to[e];
                int w = weight[e];
                if (dist[v][cur.used] > cur.cost + w) {
                    dist[v][cur.used] = cur.cost + w;
                    pq.add(new State(dist[v][cur.used], v, cur.used));
                }
                if (cur.used == 0) {
                    long nc = cur.cost + w / 2;
                    if (dist[v][1] > nc) {
                        dist[v][1] = nc;
                        pq.add(new State(nc, v, 1));
                    }
                }
            }
        }

        System.out.println(dist[n][1]);
    }
}