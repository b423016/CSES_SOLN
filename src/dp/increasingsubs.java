package dp;
import java.io.*;

import java.util.*;

public class increasingsubs {
    static final int MOD = 1_000_000_007;
    static class FenwickTree {
        int[] tree;
        int size;

        public FenwickTree(int size) {
            this.size = size;
            this.tree = new int[size + 1];
        }
        public void add(int rank, int value) {
            for (int i = rank; i <= size; i += i & -i) {
                tree[i] = (tree[i] + value) % MOD;
            }
        }
        public int query(int rank) {
            int sum = 0;
            for (int i = rank; i > 0; i -= i & -i) {
                sum = (sum + tree[i]) % MOD;
            }
            return sum;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;

        int n = Integer.parseInt(line.trim());
        int[] arr = new int[n];
        int[] sortedArr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sortedArr[i] = arr[i];
        }
        Arrays.sort(sortedArr);
        HashMap<Integer, Integer> rankMap = new HashMap<>();
        int currentRank = 1;
        for (int num : sortedArr) {
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, currentRank++);
            }
        }
        int maxRank = currentRank - 1;
        FenwickTree fenwick = new FenwickTree(maxRank);
        int totalSubsequences = 0;

        for (int i = 0; i < n; i++) {
            int value = arr[i];
            int rank = rankMap.get(value);
            int previousSequences = fenwick.query(rank - 1);
            int sequencesEndingHere = (1 + previousSequences) % MOD;
            totalSubsequences = (totalSubsequences + sequencesEndingHere) % MOD;
            fenwick.add(rank, sequencesEndingHere);
        }

        System.out.println(totalSubsequences);
    }
}