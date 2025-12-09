package rangesum;
import java.io.*;
import util.FastReader;

public class rangemin {
    public static void main(String[] args) throws Exception {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        int q = fr.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = fr.nextInt();

        int[] seg = new int[4 * n];
        build(arr, seg, 1, 0, n - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int l = fr.nextInt();
            int r = fr.nextInt();
            if (l > r) { int tmp = l; l = r; r = tmp; }
            sb.append(query(seg, 1, 0, n - 1, l, r)).append('\n');
        }
        System.out.print(sb.toString());
    }

    static void build(int[] a, int[] seg, int idx, int l, int r) {
        if (l == r) {
            seg[idx] = a[l];
            return;
        }
        int mid = (l + r) >>> 1;
        build(a, seg, idx << 1, l, mid);
        build(a, seg, idx << 1 | 1, mid + 1, r);
        seg[idx] = Math.min(seg[idx << 1], seg[idx << 1 | 1]);
    }

    static int query(int[] seg, int idx, int l, int r, int ql, int qr) {
        if (ql > r || qr < l) return Integer.MAX_VALUE;
        if (ql <= l && r <= qr) return seg[idx];
        int mid = (l + r) >>> 1;
        return Math.min(query(seg, idx << 1, l, mid, ql, qr),
                        query(seg, idx << 1 | 1, mid + 1, r, ql, qr));
    }
}
