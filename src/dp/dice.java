//package dp;

import java.util.Scanner;

public class dice {
    static int MOD = (int)1e9 + 7 ;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        long[] dp = new long[a+1]; // ways to get sum a
        dp[0] = 1;
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= 6; j++) {
                if (i - j >= 0) {
                    dp[i] = (dp[i] + dp[i - j]) % MOD;
                }
            }
        }
        System.out.println(dp[a]);
        sc.close();
    }
}
