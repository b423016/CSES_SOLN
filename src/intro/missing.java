package intro;
import java.util.Scanner;

public class missing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long sum = (long)n*(n+1)/2;
        for (int i = 0; i < n-1; i++) {
            sum -= sc.nextInt();
        }
        System.out.println(sum);
        sc.close();
    }
}
