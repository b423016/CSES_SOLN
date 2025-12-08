//package sort;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class apartment {
    // Fast byte reader
    static final class FastScanner {
        private final InputStream in;
        private final byte[] buffer;
        private int ptr = 0, len = 0;
        FastScanner(InputStream is, int bufSize) { in = is; buffer = new byte[bufSize]; }
        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }
        int nextInt() throws IOException {
            int c;
            while ((c = read()) <= ' ') if (c == -1) return Integer.MIN_VALUE;
            int sign = 1;
            if (c == '-') { sign = -1; c = read(); }
            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
        long nextLong() throws IOException {
            int c;
            while ((c = read()) <= ' ') if (c == -1) return Long.MIN_VALUE;
            int sign = 1;
            if (c == '-') { sign = -1; c = read(); }
            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }

    // 2-pass radix sort for non-negative ints (values up to ~2^31-1)
    static void radixSort(int[] a) {
        int n = a.length;
        if (n <= 64) { Arrays.sort(a); return; } // small arrays: java sort is faster
        int[] b = new int[n];
        final int RAD = 1 << 16;
        int[] cnt = new int[RAD];

        // pass 1: lower 16 bits
        for (int v : a) cnt[v & 0xFFFF]++;
        for (int i = 1; i < RAD; i++) cnt[i] += cnt[i - 1];
        for (int i = n - 1; i >= 0; i--) b[--cnt[a[i] & 0xFFFF]] = a[i];
        Arrays.fill(cnt, 0);

        // pass 2: upper 16 bits
        for (int v : b) cnt[(v >>> 16) & 0xFFFF]++;
        for (int i = 1; i < RAD; i++) cnt[i] += cnt[i - 1];
        for (int i = n - 1; i >= 0; i--) a[--cnt[(b[i] >>> 16) & 0xFFFF]] = b[i];
        // done; a is sorted
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in, 1 << 20); // 1MB buffer
        int n = fs.nextInt();
        int m = fs.nextInt();
        long k = fs.nextLong();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = fs.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) b[i] = fs.nextInt();

        radixSort(a);
        radixSort(b);

        int i = 0, j = 0, ans = 0;
        while (i < n && j < m) {
            long low = (long)a[i] - k;
            long high = (long)a[i] + k;
            if (b[j] < low) {
                j++;
            } else if (b[j] > high) {
                i++;
            } else {
                ans++; i++; j++;
            }
        }
        System.out.println(ans);
    }
}
