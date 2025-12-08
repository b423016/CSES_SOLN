//package sort;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class gondolas {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        int x = Integer.parseInt(first[1]);
        String[] second = br.readLine().split(" ");
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = Integer.parseInt(second[i]);
        }
        Arrays.sort(weights);
        int cnt = 0;
        int i = 0, j = n-1;
        while (i <= j) {
            if(weights[i] + weights[j] <= x) {
                i++;
            }
            j--;
            cnt++;
        }
        System.out.println(cnt);

    }
}
