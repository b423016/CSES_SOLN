package intro;
import java.util.*;
public class weird {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        StringBuilder sb =  new StringBuilder();
        sb.append(n);
        while(n != 1) {
            if (n % 2 != 0)
                n = n*3 + 1;
            else
                n = n/2;
            sb.append(' ').append(n);
        }
        System.out.println(sb.toString());
        sc.close();
    }

}
