package math;

import java.io.*;

public class josephus {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int q = Integer.parseInt(br.readLine());

        while (q-- > 0) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);

            sb.append(solve(n, k)).append("\n");
        }

        System.out.print(sb);
    }

    private static int solve(int n, int k) {
        if (k <= (n + 1) / 2) {
            if (2 * k > n) {
                return 2 * k - n;
            } else {
                return 2 * k;
            }
        }

        int remaining = solve(n / 2, k - (n + 1) / 2);
        if (n % 2 == 1) {
            return 2 * remaining + 1;
        }
        return 2 * remaining - 1;
    }
}
