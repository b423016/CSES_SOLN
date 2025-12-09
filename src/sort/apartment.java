package sort;
import java.io.*;
import util.FastReader;

public class apartment {
    public static void main(String[] args) throws Exception {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        int m = fr.nextInt();
        int k = fr.nextInt();

        int[] applicants = new int[n];
        for (int i = 0; i < n; i++) {
            applicants[i] = fr.nextInt();
        }

        int[] apartments = new int[m];
        for (int i = 0; i < m; i++) {
            apartments[i] = fr.nextInt();
        }

        // ...your logic here...
    }
}
