import java.io.InputStream;
import java.io.IOException;
import java.util.*;

public class sr1 {
    static class FastScanner {
        private InputStream stream;
        private byte[] buf = new byte[1 << 16]; // 64KB buffer
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

    static class Edge {
        int to;
        long weight;
        Edge(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Node implements Comparable<Node> {
        int id;
        long dist;
        Node(int id, long dist) {
            this.id = id;
            this.dist = dist;
        }
        @Override
        public int compareTo(Node other) {
            return Long.compare(this.dist, other.dist);
        }
    }

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();

        int n = sc.nextInt();
        if (n == -1) return; // EOF check
        int m = sc.nextInt();

        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            long w = sc.nextLong();
            adj.get(u).add(new Edge(v, w));
        }

        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int u = cur.id;
            long d = cur.dist;

            if (d > dist[u]) continue;

            for (Edge e : adj.get(u)) {
                int v = e.to;
                long w = e.weight;

                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(dist[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}