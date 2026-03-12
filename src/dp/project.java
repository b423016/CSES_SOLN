package dp;
import java.io.*;
import java.util.*;

public class project {

    static final class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

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
            while ((c = read()) <= ' ') {}
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }

    public static void main(String[] args) throws Exception {

        FastScanner sc = new FastScanner();

        int n = sc.nextInt();
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
        }

        long[] dp = new long[n];
        Arrays.sort(arr, Comparator.comparingInt(x -> x[1]));
        dp[0] = arr[0][2];

        int[] end = new int[n];
        for (int i = 0; i < n; i++) end[i] = arr[i][1];

        for (int i = 1; i < n; i++) {
            int start = arr[i][0];
            int reward = arr[i][2];

            int j = bs(end, start, i);

            long take = reward;
            if (j != -1) take += dp[j];

            dp[i] = Math.max(dp[i - 1], take);
        }

        System.out.println(dp[n - 1]);
    }

    public static int bs(int[] end, int start, int i) {
        int l = 0, r = i - 1, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (end[mid] < start) {
                ans = mid;
                l = mid + 1;
            } else r = mid - 1;
        }
        return ans;
    }
}
