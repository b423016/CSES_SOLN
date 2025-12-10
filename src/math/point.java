//package math;

import java.io.*;
import java.util.StringTokenizer;

public class point {
    // Fast I/O Template
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        // PrintWriter buffers the output effectively
        PrintWriter out = new PrintWriter(System.out);

        int t = sc.nextInt();
        while (t-- > 0) {
            long x1 = sc.nextLong();
            long y1 = sc.nextLong();
            long x2 = sc.nextLong();
            long y2 = sc.nextLong();
            long x3 = sc.nextLong();
            long y3 = sc.nextLong();

            // Core Logic
            long crossProduct = (x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1);

            if (crossProduct > 0) {
                out.println("LEFT");
            } else if (crossProduct < 0) {
                out.println("RIGHT");
            } else {
                out.println("TOUCH");
            }
        }

        // CRITICAL: Flush the buffer at the very end to print everything
        out.flush();
        out.close();
    }
}