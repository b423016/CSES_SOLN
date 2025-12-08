package intro;

import java.util.Scanner;

public class repetition {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if (str.isEmpty()) {
            System.out.println(0);
            return;
        }
        int cnt = 1;
        int max = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i-1)) {
                cnt++;
            }
            else
            {
                if (max < cnt)
                    max = cnt;
                cnt = 1;

            }
        }
        if(cnt > max){
            max = cnt;
        }
        System.out.println(max);
    }
}
